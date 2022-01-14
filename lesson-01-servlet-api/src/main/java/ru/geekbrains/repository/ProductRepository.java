package ru.geekbrains.repository;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    Product findById(long id);

    void save(Product product);

    void delete(long id);
}
