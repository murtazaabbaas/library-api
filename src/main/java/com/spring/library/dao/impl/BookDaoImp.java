package com.spring.library.dao.impl;

import com.spring.library.model.Book;
import com.spring.library.util.FileSystemDataHolder;
import com.spring.library.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Repository
public class BookDaoImp implements BookDao {

    @Autowired
    FileSystemDataHolder fileSystemDataHolder;

    @Override
    public List<Book> getAllBooks() {
        return fileSystemDataHolder.getBooks();
    }

    @Override
    public Book getBookById(int id) {
        return fileSystemDataHolder.getBooks().stream().filter( r -> r.getId() == id).findFirst().get();
    }

    @Override
    public boolean addBook(Book book) {
        boolean addStatus = fileSystemDataHolder.getBooks().add(book);
        fileSystemDataHolder.persistBooksData();
        return addStatus;
    }

    @Override
    public boolean updateBook(int id, Book book) {
        if(deleteBook(id)) {
            boolean addStatus = fileSystemDataHolder.getBooks().add(book);
            fileSystemDataHolder.persistBooksData();
            return addStatus;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        boolean removeStatus = fileSystemDataHolder.getBooks().removeIf(x -> x.getId() == id);
        fileSystemDataHolder.persistBooksData();
        return removeStatus;

    }
}
