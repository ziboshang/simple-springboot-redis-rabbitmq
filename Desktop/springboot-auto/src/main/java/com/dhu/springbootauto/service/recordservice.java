package com.dhu.springbootauto.service;


import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.entites.Record;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;


public interface recordservice {
    public Record getRecordById( Integer id);
    public int  deleteRecordById(Integer id);
    public void insertRecord(Book book);
    public int updateRecord(Record record);
    public List<Record> selectAll();
    public List<Record> un_users_Record(Integer id);
    public Record getRecordBy_user_and_book(Integer userid,String bookname);
}
