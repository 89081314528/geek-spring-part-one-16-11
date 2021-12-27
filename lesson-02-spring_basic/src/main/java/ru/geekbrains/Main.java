package ru.geekbrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repository.ProductRepositoryImpl;
import ru.geekbrains.service.CartService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        Map<String, CartService> mapCartService = new HashMap<>();
        String name = "Имя еще не введено";
        Scanner scanner = new Scanner(System.in);
        CartService cartService = null;
        while (true) {
            if (name.equals("Имя еще не введено")) {
                System.out.println("Введите 1, чтобы написать имя пользователя, 0, чтобы выйти");
                int toDo = scanner.nextInt();
                if (toDo == 1) {
                    System.out.println("Введите имя пользователя");
                    name = scanner.next();
                    System.out.println(name);
                    cartService = context.getBean("cartService", CartService.class);
                    mapCartService.put(name, cartService);
                }
                if (toDo == 0) {
                    return;
                }
            } else {
                System.out.println("Введите 1, чтобы написать имя пользователя, " +
                        "0, чтобы выйти, " +
                        "2 распечатать то же имя, " +
                        "3, чтобы выбрать продукт для добавления в корзину," +
                        "4, чтобы печатать содержание корзины, " +
                        "5, чтобы удалить продукт");
                int toDo = scanner.nextInt();
                if (toDo == 1) {
                    System.out.println("Введите имя пользователя");
                    name = scanner.next();
                    System.out.println(name);
                    if (!mapCartService.containsKey(name)) {
                        cartService = context.getBean("cartService", CartService.class);
                        mapCartService.put(name, cartService);
                    } else {
                        cartService = mapCartService.get(name);
                    }
                }
                if (toDo == 0) {
                    return;
                }
                if (toDo == 2) {
                    System.out.println(name);
                }
                if (toDo == 3) {
                    ProductRepositoryImpl productRepositoryImpl = context.getBean("productRepository",
                            ProductRepositoryImpl.class);
                    List<Product> productList = productRepositoryImpl.findAll();
                    for (Product product : productList) {
                        System.out.println(product);
                    }
                    System.out.println("Введите id продукта для добавления");
                    Long productId = (long) scanner.nextInt();
                    Product product = productRepositoryImpl.findById(productId);
                    System.out.println(product);
                    cartService.addById(productId);
                }
                if (toDo == 4) {
                    List<Product> productList = cartService.findAll();
                    for (Product product : productList) {
                        System.out.println(product);
                    }
                }
                if (toDo == 5) {
                    ProductRepositoryImpl productRepositoryImpl = context.getBean("productRepository",
                            ProductRepositoryImpl.class);
                    List<Product> productList = cartService.findAll();
                    for (Product product : productList) {
                        System.out.println(product);
                    }
                    System.out.println("Введите id продукта для удаления");
                    Long productId = (long) scanner.nextInt();
                    Product product = productRepositoryImpl.findById(productId);
                    System.out.println(product);
                    cartService.addDeleteById(productId);
                }
            }
        }
    }
}
