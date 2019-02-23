package com.khaliuk.model;

public class Product {
    private static Long idCounter = 0L;
    private Long id;
    private String productName;
    private String description;
    private double price;

    public Product(String productName, String description, double price) {
        this.id = ++idCounter;
        this.productName = productName;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
