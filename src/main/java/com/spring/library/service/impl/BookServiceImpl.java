package com.spring.library.service.impl;

import com.spring.library.dao.CategoryDao;
import com.spring.library.model.Book;
import com.spring.library.service.BookService;
import com.spring.library.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public boolean addBook(Book book) {
            return bookDao.addBook(book);
    }

    @Override
    public boolean updateBook(int id, Book book) {
            return bookDao.updateBook(id, book);
    }

    @Override
    public boolean deleteBook(int id) {
        return bookDao.deleteBook(id);
    }
}
