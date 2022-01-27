package ru.geekbrains.repository;

import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void init();
    List<User> findAll();
    User findById(Long id);
    void saveOrUpdate(User user);
    void delete(Long id);
    void showAllProducts(Long id);
}
