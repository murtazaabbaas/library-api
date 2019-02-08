package com.spring.library.service.impl;

import com.spring.library.service.CategoryService;
import com.spring.library.dao.CategoryDao;
import com.spring.library.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryDao.addCategory(category);
    }

    @Override
    public boolean updateCategory(int id, Category category) {
        return categoryDao.updateCategory(id, category);
    }

    @Override
    public boolean deleteCategory(int id) {
        return categoryDao.deleteCategory(id);
    }
}
