package ru.geekbrains.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
public class CartService {
    @Autowired
    private ProductRepository productRepository;

    private final Map<Long, Product> cartMap = new ConcurrentHashMap<>();

    public void addById(Long id){
        Product product = productRepository.findById(id);
        cartMap.put(product.getId(), product);
    }
    public void addDeleteById(Long id){
        Product product = productRepository.findById(id);
        cartMap.remove(id);
    }
    public List<Product> findAll(){
        List<Product> productList = new ArrayList<>(cartMap.values());
        return productList;
    }
}
