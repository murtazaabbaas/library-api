package com.spring.library.service;

import com.spring.library.model.Book;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
public interface BookService {

    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public boolean addBook(Book book);
    public boolean updateBook(int id, Book book);
    public boolean deleteBook(int id);
}
