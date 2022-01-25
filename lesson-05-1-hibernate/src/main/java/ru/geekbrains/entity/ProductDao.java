package ru.geekbrains.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.UUID;

public class ProductDao {
private EntityManagerFactory emf;
// если не передать в конструктор emf, то там будет null и при вызове в методе init() метода createEntityManager();
// будет NullPointerException
    public ProductDao(EntityManagerFactory entityManagerFactory) {
        this.emf = entityManagerFactory;
    }

    public void init() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Product("peach", 20));
        entityManager.persist(new Product("apple", 10));
        entityManager.persist(new Product("lemon", 5));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Product> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<Product> list = entityManager.createQuery("select u from Product u", Product.class).getResultList();
        for (Product product : list) {
            System.out.println(product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }

    public Product findById(UUID id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        System.out.println(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    public void saveOrUpdate(Product product) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void delete(UUID id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
