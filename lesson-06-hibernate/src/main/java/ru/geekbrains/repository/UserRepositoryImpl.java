package ru.geekbrains.repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Product;
import ru.geekbrains.entity.User;
import ru.geekbrains.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
@Repository
public class UserRepositoryImpl implements UserRepository {

    final EntityManagerFactory emf;

    public UserRepositoryImpl(EntityManagerFactory emFactory) {
        this.emf = emFactory;
    }

    @Override
    public void init() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new User(1L,"julia", "123"));
        entityManager.persist(new User(2L,"anna", "1234"));
        entityManager.persist(new User(3L,"irina", "12345"));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Override
    public List<User> findAll() {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        List<User> list = entityManager.createQuery("select u from Product u", User.class).getResultList();
        for (User user : list) {
            System.out.println(user);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }
    @Override
    public User findById(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        System.out.println(user);
        entityManager.getTransaction().commit();
        entityManager.close();
        return user;
    }

    @Override
    public void saveOrUpdate(User user) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void showAllProducts(Long id) {
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class, id);
        List<Product> productList = user.getProducts();
        for (Product product : productList) {
            System.out.println(product);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
