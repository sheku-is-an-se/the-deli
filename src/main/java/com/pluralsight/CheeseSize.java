package com.pluralsight;

public enum CheeseSize {

    SMALL(0.75, .30),
    MEDIUM(1.50, 0.60),
    LARGE(2.25, 0.90);

    private double basePrice;
    private double extra;

    CheeseSize(double basePrice, double extra) {
        this.basePrice = basePrice;
        this.extra = extra;

    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getExtra() {
        return extra;
    }
}


