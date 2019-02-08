package com.spring.library.service;

import com.spring.library.model.Category;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
public interface CategoryService {

    public List<Category> getAllCategories();
    public Category getCategoryById(int id);
    public boolean addCategory(Category category);
    public boolean updateCategory(int id, Category category);
    public boolean deleteCategory(int id);
}
