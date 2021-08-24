package com.codeup.blogapp.web;


import com.codeup.blogapp.data.CategoriesRepository;
import com.codeup.blogapp.data.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/categories", headers = "/application/json", produces = "application/json")
public class CategoriesController {

    private final CategoriesRepository categoriesRepository;

    public CategoriesController(CategoriesRepository categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }

    @GetMapping
    private List<Category> getPostsByCategory(){
        return categoriesRepository.findAll();

    }

    @PostMapping
    private void createCategories(Category category){
        categoriesRepository.save(category);
    }

    @PutMapping
    private void updateCategory(Category category){
        categoriesRepository.save(category);
    }

    @DeleteMapping
    private void deleteCategory(@PathVariable long id){
        categoriesRepository.deleteById(id);
    }
}
