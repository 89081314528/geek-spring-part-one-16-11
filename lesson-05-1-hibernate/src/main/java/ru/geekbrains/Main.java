package ru.geekbrains;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.ProductDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        ProductDao productDao = new ProductDao(entityManagerFactory);
        productDao.init();
        productDao.findAll();
        productDao.findById(UUID.fromString("9489444d-7e2a-4dca-b48d-f7639391f568"));
        Product product = new Product(UUID.fromString("9489444d-7e2a-4dca-b48d-f7639391f568"), "carrot", 5);
        productDao.saveOrUpdate(product);
        productDao.delete(UUID.fromString("017c7c66-b63c-4528-8f5f-599268124ed5"));

//        Теория:
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
        // создание
//        entityManager.getTransaction().begin();
//        entityManager.persist(new Product("lemon", 20));
//        entityManager.getTransaction().commit();

        // select 1
//        entityManager.getTransaction().begin();
//        Product product = entityManager.find(Product.class, UUID.fromString("9489444d-7e2a-4dca-b48d-f7639391f568"));
//        System.out.println(product);
//        entityManager.getTransaction().commit();

        //select 2
//        entityManager.getTransaction().begin();
//        List<Product> list = entityManager.createQuery("select u from Product u", Product.class).getResultList();
//        for (Product product : list) {
//            System.out.println(product);
//        }
//        entityManager.getTransaction().commit();

        //select 3
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createNativeQuery("select title from products");
//        List resultList = query.getResultList();
//        System.out.println(resultList);
//        entityManager.getTransaction().commit();

        // update 1
//        entityManager.getTransaction().begin();
//        Product product = entityManager.find(Product.class, UUID.fromString("9489444d-7e2a-4dca-b48d-f7639391f568"));
//        entityManager.getTransaction().begin();
//        product.setTitle("blue_peach");
//        entityManager.getTransaction().commit();

        // update 2
//        Product product = new Product(UUID.fromString("9489444d-7e2a-4dca-b48d-f7639391f568"), "carrot", 5);
//        entityManager.getTransaction().begin();
//        entityManager.merge(product);
//        entityManager.getTransaction().commit();
//
        // update 3
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("update Product set title =:title where id=:id")
//                .setParameter("title", "potato")
//                .setParameter("id", UUID.fromString("9489444d-7e2a-4dca-b48d-f7639391f568"))
//                .executeUpdate();
//        entityManager.getTransaction();
//        entityManager.getTransaction().commit();

        // delete
//        Product product = entityManager.find(Product.class, UUID.fromString("35ed2ea7-6cca-40ce-ae74-0742046086a1"));
//        entityManager.getTransaction().begin();
//        entityManager.remove(product);
//        entityManager.getTransaction().commit();

        // delete 2
//        entityManager.getTransaction().begin();
//        entityManager.createQuery("delete from Product where id=:id")
//                .setParameter("id", 9489444d-7e2a-4dca-b48d-f7639391f568)
//                .executeUpdate();
//        entityManager.getTransaction().commit();

//        entityManager.close();
    }
}
