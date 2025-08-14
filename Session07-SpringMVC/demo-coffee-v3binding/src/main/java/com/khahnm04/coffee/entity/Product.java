package com.khahnm04.coffee.entity;

// tương lai là @Entity để xuống table, nay làm nháp trong RAM, hard-code data thay vì lấy từ table
public class Product {

    private String id; // nếu key tự tăng -> dùng Long (wrapper class - số nhưng lưu như là Object, ko dùng primitive)
    private String name;
    private double price;

    // boiler-play code: constructor, get/set, toString()

    public Product() {}

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
