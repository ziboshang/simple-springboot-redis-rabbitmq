package com.dhu.springbootauto.service;


import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface bookservice {

    public List<Book> allBook();
    public Book getBookById(Integer id);
    public int deleteBook(Integer id);
    public int insertBook(Book book);
    public int updateBook(Book book);

    public List<Book> all_unborrowed_Book();

    public List<Book> all_unusers_Book(Integer id);

    public List<Book> one_page_book(int pos,String keyword);
    public int book_number();


}
