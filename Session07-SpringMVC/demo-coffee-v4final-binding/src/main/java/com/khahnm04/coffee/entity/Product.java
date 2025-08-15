package com.khahnm04.coffee.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Product")
public class Product {

    @Id
    @Column(name = "Id", columnDefinition = "CHAR(4)")
    @NotBlank(message = "Id is required! - Phải nhập Id!")
    @Size(min = 4, max = 4, message = "Id length must be 4 characters")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    @NotBlank(message = "Name is required! - Phải nhập tên!")
    @Size(min = 5, max = 50, message = "Name length must be between 5...50 characters")
    @Pattern(
        regexp = "^(\\p{Lu}\\p{Ll}+)(\\s\\p{Lu}\\p{Ll}+)*$",
        message = "Mỗi từ phải bắt đầu hoa, chỉ chứa chữ (Unicode), không số/ký tự đặc biệt, không khoảng trắng thừa"
    )
    private String name;

    @Column(name = "Quantity", nullable = false)
    @NotNull(message = "Quantity is required!")
    @Min(value = 5, message = "Quantity must be between 5...10K")
    @Max(value = 10_000, message = "Quantity must be between 5...10K")
    private int quantity;

    @Column(name = "Price", nullable = false)
    @NotNull(message = "Price is required!")
    @Min(value = 10_000, message = "Price must be between 10K...100M")
    @Max(value = 100_000_000, message = "Price must be between 10K...100M")
    private double price;

    // Category -------< Product
    @ManyToOne
    @JoinColumn(name = "cateId")
    private Category cate;

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    public Product() {}

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

}
