package com.spring.library.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookIssueRecord {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("book")
    private Book book;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
