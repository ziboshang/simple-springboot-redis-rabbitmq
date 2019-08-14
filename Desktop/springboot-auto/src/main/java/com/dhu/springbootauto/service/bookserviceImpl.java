package com.dhu.springbootauto.service;

import com.dhu.springbootauto.entites.Book;
import com.dhu.springbootauto.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class bookserviceImpl implements bookservice{

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Book> allBook() {
        return bookMapper.selectAll();
    }

    @Override
    @Cacheable(cacheNames = {"book"})
    public Book getBookById(Integer id) {
        return bookMapper.getBookById(id);
    }

    @Override
    @CacheEvict(cacheNames = {"book"})
    public int deleteBook(Integer id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    @CachePut(cacheNames = {"book"})
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }

    @Override
    public List<Book> all_unborrowed_Book() {
        return bookMapper.All_unborrowed_book();
    }

    @Override
    public List<Book> all_unusers_Book(Integer id) {
        return bookMapper.all_unusers_Book(id);
    }

    @Override
    @CachePut(cacheNames = {"book"})
    public int updateBook(Book book) {

        return bookMapper.updateBook(book);
    }

    @Override
    public List<Book> one_page_book(int page,String keyword) {

        int pos = 15*(page-1);

        if(keyword==null){
            return bookMapper.one_page_book_without_word(pos);
        }
        return bookMapper.one_page_book(pos,keyword);
    }

    @Override
    public int book_number() {
        return bookMapper.book_number();
    }
}
