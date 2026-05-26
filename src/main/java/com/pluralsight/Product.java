package com.pluralsight;

public abstract class Product {
    private String name;
    private String size;

    public Product(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public abstract double getPrice();

}
