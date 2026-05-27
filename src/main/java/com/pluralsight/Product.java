package com.pluralsight;

public abstract class Product implements Priceable {
    private String name;
    private String size;
    private String type;

    public Product(String name, String size, String type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public abstract double getPrice();

}
