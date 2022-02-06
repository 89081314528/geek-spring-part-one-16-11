package ru.geekbrains.service;

import ru.geekbrains.persist.Product;

import java.util.List;

public interface CartService {
    public Product addProduct(Long id);
    public Product deleteProduct(Long id);
    public List<Product> getAllProducts();
}
