package com.spring.library.service.impl;

import com.spring.library.dao.UserBookManagementDao;
import com.spring.library.model.Book;
import com.spring.library.service.UserBookManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserBookManagementImpl implements UserBookManagement {

    @Autowired
    UserBookManagementDao userBookManagementDao;

    @Override
    public Map<Integer, List<Book>> getUserBookRecordAll() {
        return userBookManagementDao.getUserBookRecordAll();
    }

    @Override
    public boolean bookReturn(int userId, int bookId) {
        return userBookManagementDao.bookReturn(userId, bookId);
    }

    @Override
    public boolean bookIssue(int userId, Book book) {
        return userBookManagementDao.bookIssue(userId, book);
    }
}
