package ru.geekbrains.repository;

import ru.geekbrains.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

    void delete(Long id);
}
