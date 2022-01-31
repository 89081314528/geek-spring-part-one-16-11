package ru.geekbrains.service;

import ru.geekbrains.persist.Category;

public interface CategoryService {

    public Category createCategory(Category category);

    public Category getCategoryById(Long id);

    public Category updateCategory(Category category);

    public void deleteCategory (Long id);

}
