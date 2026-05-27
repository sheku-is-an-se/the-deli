package com.pluralsight;

public abstract class Product implements Sellable {
    private String name;
    private String size;

    public Product(String name, String size) {
        this.name = name;
        this.size = size;
    }

    public String getSize() {
        return size;
    }


    public abstract double getPrice();

}
