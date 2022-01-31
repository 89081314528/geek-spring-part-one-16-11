package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.dto.CategoryDto;
import ru.geekbrains.persist.Category;
import ru.geekbrains.persist.CategoryRepository;

import javax.xml.catalog.Catalog;
import java.util.Collection;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory (Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Collection<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

}
