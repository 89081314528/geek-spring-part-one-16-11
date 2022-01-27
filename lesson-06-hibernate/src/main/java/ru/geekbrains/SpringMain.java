package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.User;
import ru.geekbrains.repository.ProductRepository;
import ru.geekbrains.repository.UserRepository;

public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        Product product = productRepository.findById(1L);
        System.out.println(product);

        UserRepository userRepository = context.getBean(UserRepository.class);
        User user = userRepository.findById(1L);
        System.out.println(user);
    }
}
