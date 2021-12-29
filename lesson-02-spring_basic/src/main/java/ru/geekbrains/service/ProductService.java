package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

import javax.annotation.PostConstruct;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        productRepository.save(new Product(null, "Product 1", 10000));
        productRepository.save(new Product(null, "Product 2", 20000));
        productRepository.save(new Product(null, "Product 3", 20000));
        productRepository.save(new Product(null, "Product 4", 30000));
        productRepository.save(new Product(null, "Product 5", 40000));
    }

    public long count() {
        return productRepository.findAll().size();
    }
}
