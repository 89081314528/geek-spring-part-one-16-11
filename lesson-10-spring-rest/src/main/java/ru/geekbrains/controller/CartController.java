package ru.geekbrains.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.persist.Product;
import ru.geekbrains.service.CartService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/add/{id}") // почему не работает?
    public ResponseEntity<Product> addProduct(@PathVariable Long id) {
        Product product = cartService.addProduct(id);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Product product = cartService.deleteProduct(id);
        if (product == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/findAll")
    public List<Product> getAllProducts() {
        return cartService.getAllProducts();
    }
}
