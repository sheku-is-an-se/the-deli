package com.pluralsight;

public class Sides extends Product {
    public Sides(String name, Size size) {
        super(name, size);
    }

    @Override
    public double getPrice() {
        return 0.0;
    }

    @Override
    public String toString() {
        return "  - " + this.getName() + ": $" + this.getPrice();
    }
}
