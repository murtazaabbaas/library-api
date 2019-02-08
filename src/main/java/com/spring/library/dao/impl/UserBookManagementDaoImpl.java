package com.spring.library.dao.impl;

import com.spring.library.dao.UserBookManagementDao;
import com.spring.library.model.Book;
import com.spring.library.util.FileSystemDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class UserBookManagementDaoImpl implements UserBookManagementDao {

    @Autowired
    FileSystemDataHolder fileSystemDataHolder;

    @Override
    public Map<Integer, List<Book>> getUserBookRecordAll() {
        return fileSystemDataHolder.getUserBooks();
    }

    @Override
    public boolean bookReturn(int userId, int bookId) {
        if(fileSystemDataHolder.getUserBooks() == null) {
            return false;
        }

        if(fileSystemDataHolder.getUserBooks().containsKey(userId)){
            List<Book> books = fileSystemDataHolder.getUserBooks().get(userId);
            boolean removeStatus = books.removeIf(x -> x.getId() == bookId);
            fileSystemDataHolder.persistUserBooksData();
            return removeStatus;
        }

        return false;
    }

    @Override
    public boolean bookIssue(int userId, Book book) {
        if(fileSystemDataHolder.getUserBooks() == null) {
            return false;
        }

        if(fileSystemDataHolder.getUserBooks().containsKey(userId)){
            List<Book> books = fileSystemDataHolder.getUserBooks().get(userId);
            boolean addStatus = books.add(book);
            fileSystemDataHolder.persistUserBooksData();
            return addStatus;
        }

        List<Book> books = new ArrayList<>();
        books.add(book);
        fileSystemDataHolder.getUserBooks().put(userId, books);
        fileSystemDataHolder.persistUserBooksData();
        return true;
    }
}
