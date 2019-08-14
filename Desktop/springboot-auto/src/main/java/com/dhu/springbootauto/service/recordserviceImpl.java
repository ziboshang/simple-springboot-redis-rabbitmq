package com.dhu.springbootauto.service;

import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.entites.Record;
import com.dhu.springbootauto.mapper.RecordMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class recordserviceImpl implements recordservice{

    @Autowired
    RecordMapper recordMapper;



    @Override
    public Record getRecordById(Integer id) {
        return recordMapper.getRecordById(id);
    }

    @Override
    public int deleteRecordById(Integer id) {
        return recordMapper.deleteRecordById(id);
    }

//    @Override
//    public int insertRecord(Date borrowtime,Integer userid,String bookname) {
//        return recordMapper.insertRecord(borrowtime,userid,bookname);
//    }

    @Override
    @RabbitListener(queues = "book_borrow")
    public void insertRecord(Book book) {
        System.out.println(book);
        Date borrowtime = new Date();
        recordMapper.insertRecord(borrowtime,book.getOwner(),book.getName());
    }

    @Override
    public int updateRecord(Record record) {
        return recordMapper.updateRecord(record);
    }

    @Override
    public List<Record> selectAll() {
        return recordMapper.selectAll();
    }

    @Override
    public List<Record> un_users_Record(Integer id) {
        return recordMapper.un_users_Record(id);
    }

    @Override
    public Record getRecordBy_user_and_book(Integer userid,String bookname) {
        return recordMapper.getRecordBy_user_and_book(userid,bookname);
    }

//    @RabbitListener(queues = "book_borrow")
//    public void listen(Book book)
//    {
//        System.out.println("接收消息"+book.toString());
//        Date borrowtime = new Date();
//        recordMapper.insertRecord(borrowtime,book.getOwner(),book.getName());
//    }
}
