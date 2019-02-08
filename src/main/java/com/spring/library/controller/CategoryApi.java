package com.spring.library.controller;

import com.spring.library.model.Category;
import com.spring.library.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Murtaza on 2/7/2019.
 */
@RestController
public class CategoryApi {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/category/{id}")
    public Category getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/category")
    public boolean addCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }

    @PutMapping("/category/{id}")
    public boolean updateCategory(@PathVariable int id, @RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/category/{id}")
    public boolean deleteCategory(@PathVariable int id){
        return categoryService.deleteCategory(id);
    }
}
