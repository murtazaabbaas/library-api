package com.spring.library.controller;

import com.spring.library.model.Book;
import com.spring.library.service.BookService;
import com.spring.library.util.FileSystemDataHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */

@RestController
public class BookApi {

    private static final Logger logger = LogManager.getLogger(FileSystemDataHolder.class);

    @Autowired
    private BookService bookService;

    @GetMapping("/book/all")
    public List<Book> getAllBooks(){
        logger.info("Request received getAllBooks()");
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable int id){
        logger.info("Request received getBookById(%s)", id);
        return bookService.getBookById(id);
    }

    @PostMapping("/book")
    public boolean addBook(@RequestBody Book book){
        logger.info("Request received addBook(%s)", book.getId());
        return bookService.addBook(book);
    }

    @PutMapping("/book/{id}")
    public boolean updateBook(@PathVariable int id, @RequestBody Book book){
        logger.info("Request received updateBook(%s)", id);
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/book/{id}")
    public boolean deleteBook(@PathVariable int id){
        logger.info("Request received deleteBook(%s)", id);
        return bookService.deleteBook(id);
    }
}
