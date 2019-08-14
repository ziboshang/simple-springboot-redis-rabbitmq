package com.dhu.springbootauto.mapper;

import com.dhu.springbootauto.entites.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface BookMapper {

    public Book getBookById(@Param("id") Integer id);
    public int  deleteBookById(@Param("id") Integer id);
    public int insertBook(Book book);
    public int updateBook(Book book);
    public List<Book> selectAll();
    public List<Book> All_unborrowed_book();
    public List<Book> all_unusers_Book(@Param("id") Integer id);
    public List<Book> one_page_book(@Param("pos") int pos,@Param("keyword") String keyword);
    public List<Book> one_page_book_without_word(@Param("pos") int pos);
    public int book_number();

}
