package ru.geekbrains.service;

import ru.geekbrains.persist.Category;

import java.util.Collection;
import java.util.List;

public interface CategoryService {

    public Category createCategory(Category category);

    public Category getCategoryById(Long id);

    public Category updateCategory(Category category);

    public void deleteCategory (Long id);

    public Collection<Category> getAllCategories();

}
