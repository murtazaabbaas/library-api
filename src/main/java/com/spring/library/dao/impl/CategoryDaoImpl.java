package com.spring.library.dao.impl;

import com.spring.library.dao.CategoryDao;
import com.spring.library.model.Category;
import com.spring.library.util.FileSystemDataHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Repository
public class CategoryDaoImpl implements CategoryDao {
    @Autowired
    FileSystemDataHolder fileSystemDataHolder;

    @Override
    public List<Category> getAllCategories() {
        return fileSystemDataHolder.getCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        try {
            return fileSystemDataHolder.getCategories().stream().filter(r -> r.getId() == id).findFirst().get();
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public boolean addCategory(Category category) {
        boolean addStatus = fileSystemDataHolder.getCategories().add(category);
        fileSystemDataHolder.persistCategoriesData();
        return addStatus;
    }

    @Override
    public boolean updateCategory(int id, Category category) {
        if(deleteCategory(id)) {
            boolean addStatus = fileSystemDataHolder.getCategories().add(category);
            fileSystemDataHolder.persistCategoriesData();
            return addStatus;
        }
        return false;
    }

    @Override
    public boolean deleteCategory(int id) {
        boolean removeStatus =  fileSystemDataHolder.getCategories().removeIf(x -> x.getId() == id);
        fileSystemDataHolder.persistCategoriesData();
        return removeStatus;
    }
}
