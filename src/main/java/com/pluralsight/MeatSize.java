package com.pluralsight;

public enum MeatSize {

    SMALL(1.00, .50),
    MEDIUM(2.00, 1.00),
    LARGE(3.00, 1.50);

    private double basePrice;
    private double extra;

    MeatSize(double basePrice, double extra) {
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
