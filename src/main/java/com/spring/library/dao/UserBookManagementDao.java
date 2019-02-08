package com.spring.library.dao;

import com.spring.library.model.Book;

import java.util.List;
import java.util.Map;

public interface UserBookManagementDao {
    public Map<Integer, List<Book>> getUserBookRecordAll();
    public boolean bookReturn(int userId, int bookId);
    public boolean bookIssue(int userId, Book book);
}
