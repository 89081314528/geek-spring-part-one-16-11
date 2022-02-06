package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.persist.Product;
import ru.geekbrains.persist.ProductRepository2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService{

    Map<Long,Product> productMap = new HashMap<>();
    private final ProductRepository2 productRepository;

    public CartServiceImpl(ProductRepository2 productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        //productRepository.findById(id) если нет продукта, вернет пустой optional
        //.get выдаст ошибку, поэтому пишем orElse(null)
        if (product != null) {
            productMap.put(id, product);
        }
            return product;
    }

    @Override
    public Product deleteProduct(Long id) {
            return productMap.remove(id);

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> listProducts = new ArrayList<>();
        for (Product product : productMap.values()) {
            listProducts.add(product);
        }
        return listProducts;
    }
}
