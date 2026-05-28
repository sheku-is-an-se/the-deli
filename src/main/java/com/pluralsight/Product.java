package com.pluralsight;

public abstract class Product implements Sellable {
    private final Size size;
    private final String name;

    public Product(String name, Size size) {
        this.name = name;
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();
}