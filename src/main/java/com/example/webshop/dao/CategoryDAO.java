package com.example.webshop.dao;

import com.example.webshop.dto.CategoryDTO;
import com.example.webshop.models.Category;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryDAO {

    private final CategoryRepository categoryRepository;

    public CategoryDAO(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    public Category getCategoryById(long id) {
        return this.categoryRepository.findById(id).orElse(null);
    }

    @Transactional
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.name);
        this.categoryRepository.save(category);
    }

    @Transactional
    public void updateCategory(long id, CategoryDTO categoryDTO) {
        Category category = this.categoryRepository.findById(id).orElse(null);
        if (category != null) {
            category.setName(categoryDTO.name);
            this.categoryRepository.save(category);
        }
        else {
            throw new RuntimeException("Category not found");
        }
    }

    @Transactional
    public void deleteCategory(long id) {
        try {
            this.categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Category not found");
        }
    }
}
