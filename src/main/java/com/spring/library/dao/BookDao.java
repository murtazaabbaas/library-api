package com.spring.library.dao;

import com.spring.library.model.Book;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
public interface BookDao {

    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public boolean addBook(Book book);
    public boolean updateBook(int id, Book book);
    public boolean deleteBook(int id);
}
