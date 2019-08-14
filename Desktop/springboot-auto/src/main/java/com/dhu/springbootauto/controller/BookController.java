package com.dhu.springbootauto.controller;

import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.entites.Record;
import com.dhu.springbootauto.mapper.BookMapper;
import com.dhu.springbootauto.mapper.RecordMapper;
import com.dhu.springbootauto.service.bookservice;
import com.dhu.springbootauto.service.recordservice;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    bookservice Bookservice;

    @Autowired
    recordservice Recordservice;

    //消息队列
    @Autowired
    RabbitTemplate rabbitTemplate;


    @GetMapping("/borrow")
    public String borrow_a_book(HttpSession httpSession, @RequestParam("bookid") Integer bookid,@RequestParam("page") int page,
    @RequestParam("keyword") String keyword){
        Book b = Bookservice.getBookById(bookid);
        System.out.println(b);
        b.setStatus(1);
        Object id  = httpSession.getAttribute("UserId");
        Integer ID = (Integer)id;
        b.setOwner(ID);
        Bookservice.updateBook(b);
        //存入消息中间件
        rabbitTemplate.convertAndSend("exchange.direct","book_borrow",b);
        //相关方法会在记录表中增加一条记录

        return "redirect:/main?page="+String.valueOf(page)+"&keyword="+keyword;
    }

    @GetMapping("/return")
    public String return_a_book(HttpSession httpSession, @RequestParam("bookid") Integer bookid){
        Book b = Bookservice.getBookById(bookid);
        b.setStatus(0);
        Object id  = httpSession.getAttribute("UserId");
        Integer ID = (Integer)id;
        b.setOwner(999);
        Bookservice.updateBook(b);

        Date returntime = new Date();
        Record record = Recordservice.getRecordBy_user_and_book(ID,b.getName());
        record.setReturntime(returntime);
        Recordservice.updateRecord(record);

        return "redirect:/now_reading";
    }


    @GetMapping("/now_reading")
    public String mybook(HttpSession httpSession,Model model)
    {
        Object id  = httpSession.getAttribute("UserId");
        Integer ID = (Integer)id;
        List<Book> books = Bookservice.all_unusers_Book(ID);
        model.addAttribute("books",books);
        return "now_reading";
    }

    @GetMapping("/record_user")
    public String gotorecord_user(HttpSession httpSession,Model model)
    {
        Object id  = httpSession.getAttribute("UserId");
        Integer ID = (Integer)id;
        List<Record> myrecords = Recordservice.un_users_Record(ID);
        model.addAttribute("records",myrecords);
        return "record_user";
    }








}



