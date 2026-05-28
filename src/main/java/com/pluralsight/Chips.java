package com.pluralsight;

public class Chips extends Product {
    private String type;

    private double defaultBase;
    private double mediumBase;
    private double largeBase;

    public Chips(String name, Size size, String type) {
        super(name, size);
        this.type = type;
    }

    @Override
    public double getPrice() {

        return 1.50;
    }
}
