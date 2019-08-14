package com.dhu.springbootauto.controller;


import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.entites.User;
import com.dhu.springbootauto.mapper.BookMapper;
import com.dhu.springbootauto.mapper.UserMapper;
import com.dhu.springbootauto.service.UserService;
import com.dhu.springbootauto.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


//这个类的方法解决一些功能性的页面跳转问题
@Controller
public class PageController {

    @Autowired
    bookservice Bookservice;

    @Autowired
    UserService userService;


    @GetMapping("/main0")
    public String tomain0(Model model,int page,@RequestParam("keyword") String keyword){
        List<Book> books = Bookservice.one_page_book(page,keyword);
        model.addAttribute("books",books);

        //计算页数相关问题

        model.addAttribute("nowpage",page);
        if(page==1) {
            model.addAttribute("prepage",1);
        }
        else{
            model.addAttribute("prepage",page-1);
        }


        model.addAttribute("keyword",keyword);
        return "main0";
    }

    @GetMapping("/main")
    public String tomain(Model model,int page,@RequestParam("keyword") String keyword){
        List<Book> books = Bookservice.one_page_book(page,keyword);
        model.addAttribute("books",books);
        model.addAttribute("nowpage",page);
        if(page==1) {
            model.addAttribute("prepage",1);
        }
        else{
            model.addAttribute("prepage",page-1);
        }
        model.addAttribute("keyword",keyword);
        return "main";
    }


    @GetMapping("/main_admin")
    public String tomain1(Model model,int page,@RequestParam("keyword") String keyword){
        List<Book> books = Bookservice.one_page_book(page,keyword);
        model.addAttribute("books",books);
        model.addAttribute("nowpage",page);
        if(page==1) {
            model.addAttribute("prepage",1);
        }
        else{
            model.addAttribute("prepage",page-1);
        }
        model.addAttribute("keyword",keyword);
        return "administrator";
    }

    @GetMapping("user_information")
    public String touserinfo(Model model){
        List<User> users = userService.alluser();
        model.addAttribute("users",users);
        return "user_information";
    }


}
