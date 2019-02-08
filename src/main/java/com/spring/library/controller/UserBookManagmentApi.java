package com.spring.library.controller;

import com.spring.library.model.Book;
import com.spring.library.model.User;
import com.spring.library.service.UserBookManagement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UserBookManagmentApi {

    @Autowired
    private UserBookManagement userBookManagement;

    @GetMapping("/bookissue/records")
    public Map<Integer, List<Book>> bookIssueAllRecord(){
        return userBookManagement.getUserBookRecordAll();
    }

    @PutMapping("/bookissue/{userId}")
    public boolean bookIssue(@PathVariable int userId, @RequestBody Book book){
        return userBookManagement.bookIssue(userId, book);
    }

    @DeleteMapping("/bookissue/{userId}/{bookId}")
    public boolean bookReturn(@PathVariable int userId, @PathVariable int bookId){
        return userBookManagement.bookReturn(userId, bookId);
    }

}
