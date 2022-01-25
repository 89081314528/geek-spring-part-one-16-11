package ru.geekbrains.repository;

import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.User;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void init();
    List<Product> findAll();
    Product findById(Long id);
    void saveOrUpdate(Product product);
    void delete(Long id);
    void showAllUsers(Long id);
}
