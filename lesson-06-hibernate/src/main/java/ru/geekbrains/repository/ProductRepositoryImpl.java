package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    final EntityManagerFactory emf;

    public ProductRepositoryImpl(EntityManagerFactory emFactory) {
        this.emf = emFactory;
    }

    @Override
    public void init() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Product(1L, "peach", new BigDecimal(20)));
        entityManager.persist(new Product(2L, "apple", new BigDecimal(10)));
        entityManager.persist(new Product(3L, "lemon", new BigDecimal(5)));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
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

    @Override
    public Product findById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        System.out.println(product);
        entityManager.getTransaction().commit();
        entityManager.close();
        return product;
    }

    @Override
    public void saveOrUpdate(Product product) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        entityManager.remove(product);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void showAllUsers(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        Product product = entityManager.find(Product.class, id);
        List<User> userList = product.getUsers();
        for (User user : userList) {
            System.out.println(product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
