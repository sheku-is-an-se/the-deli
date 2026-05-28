package com.pluralsight;

public class Drinks extends Product {
    private String type;
    private Size size;

    private double smallBase;
    private double mediumBase;
    private double largeBase;

    public Drinks(String name, Size size, String type) {
        super(name, size);
        this.type = type;

        this.smallBase = 2.00;
        this.mediumBase = 2.50;
        this.largeBase = 3.00;
    }

    @Override
    public double getPrice() {
        double base = 0;

        if(this.size == Size.SMALL){
            base += this.smallBase;
        } else if (this.size == Size.MEDIUM) {
            base += this.mediumBase;
        } else if (this.size == Size.LARGE) {
            base += this.largeBase;
        }
        return base;
    }
}
