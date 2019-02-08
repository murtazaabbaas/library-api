package com.spring.library;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.library.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApiApplicationTests {

	@Test
	public void contextLoads() throws IOException {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setAuthorName("murtaza");
        book.setCategoryId(1);
        book.setId(1);
        book.setName("java");
        books.add(book);

        System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(books));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(books);
        System.out.printf("----------- " + json);
    }

    public static class BookData{
        private List<Book> bookDataList;

        public List<Book> getBookDataList() {
            return bookDataList;
        }

        public void setBookDataList(List<Book> bookDataList) {
            this.bookDataList = bookDataList;
        }
    }
}

