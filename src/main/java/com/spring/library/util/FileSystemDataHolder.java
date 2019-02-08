package com.spring.library.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.spring.library.model.User;
import com.spring.library.model.Book;
import com.spring.library.model.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Component
public class FileSystemDataHolder {

    private static final Logger logger = LogManager.getLogger(FileSystemDataHolder.class);

    private static final String BOOK_PERSIST_FILENAME = "book";
    private static final String CATEGORY_PERSIST_FILENAME = "category";
    private static final String USER_PERSIST_FILENAME = "user";
    private static final String USER_BOOK_PERSIST_FILENAME = "user-book";

    private List<User> users = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Category> categories = new ArrayList<>();
    private Map<Integer, List<Book>> userBooks = new HashMap<>();

    @Value("${api.filesystem.format}")
    String fileSystemFormat;

    @PostConstruct
    public void init() {
        try {
            ObjectMapper objectMapper;
            String fileName = BOOK_PERSIST_FILENAME + fileSystemFormat;
            if (verifyFile(fileName)) {
                byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
                objectMapper = new ObjectMapper();
                books = objectMapper.readValue(jsonData, new TypeReference<List<Book>>() {
                });
            }

            fileName = USER_PERSIST_FILENAME + fileSystemFormat;
            if (verifyFile(fileName)) {
                byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
                objectMapper = new ObjectMapper();
                users = objectMapper.readValue(jsonData, new TypeReference<List<User>>() {
                });
            }

            fileName = CATEGORY_PERSIST_FILENAME + fileSystemFormat;
            if (verifyFile(fileName)) {
                byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
                objectMapper = new ObjectMapper();
                categories = objectMapper.readValue(jsonData, new TypeReference<List<Category>>() {
                });
            }

            fileName = USER_BOOK_PERSIST_FILENAME + fileSystemFormat;
            if (verifyFile(fileName)) {
                byte[] jsonData = Files.readAllBytes(Paths.get(fileName));
                objectMapper = new ObjectMapper();
                userBooks = objectMapper.readValue(jsonData, new TypeReference<Map<Integer, List<Book>>>() {
                });
            }
        } catch (IOException e) {
            logger.error("Exception in init(): ", e);
        }
    }

    public void persistBooksData() {
        if (books != null || books.size() > 0) {
            try {
                writeData(BOOK_PERSIST_FILENAME + fileSystemFormat, books);
            } catch (IOException e) {
                logger.error("Exception occurred while persist book data ", e);
            }
        }
    }

    public void persistUsersData() {
        if (users != null || users.size() > 0) {
            try {
                writeData(USER_PERSIST_FILENAME + fileSystemFormat, users);
            } catch (IOException e) {
                logger.error("Exception occurred while persist user data ", e);
            }
        }
    }

    public void persistCategoriesData() {
        if (categories != null || categories.size() > 0) {
            try {
                writeData(CATEGORY_PERSIST_FILENAME + fileSystemFormat, categories);
            } catch (IOException e) {
                logger.error("Exception occurred while persist category data ", e);
            }
        }
    }

    public void persistUserBooksData() {
        if (userBooks != null || userBooks.size() > 0) {
            try {
                writeData(USER_BOOK_PERSIST_FILENAME + fileSystemFormat, userBooks);
            } catch (IOException e) {
                logger.error("Exception occurred while persist user-book data ", e);
            }
        }
    }

    private boolean verifyFile(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    private void writeData(String fileName, Object sourceClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(fileName), sourceClass);
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Map<Integer, List<Book>> getUserBooks() {
        return userBooks;
    }
}
