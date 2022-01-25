package ru.geekbrains.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "products")
public class Product {
    @Column(name = "product_id")
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(generator = "uuid2")
    UUID id;
    @Column(name ="title")
    String title;
    @Column(name = "price")
    int price;

    public Product(UUID id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public Product(){}

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
