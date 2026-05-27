package com.pluralsight;

public class Chips extends Product {
    public Chips(String name, String size) {
        super(name, size);
    }

    @Override
    public double getPrice() {
        return 1.50;
    }
}
