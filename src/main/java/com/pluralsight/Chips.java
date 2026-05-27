package com.pluralsight;

public class Chips extends Product {
    public Chips(String name, String size, String type) {
        super(name, size, type);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
