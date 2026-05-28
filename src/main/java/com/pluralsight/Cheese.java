package com.pluralsight;

public class Cheese extends Ingredient {

    private double smallBase;
    private double smallExtra;
    private double mediumBase;
    private double mediumExtra;
    private double largeBase;
    private double largeExtra;

    public Cheese(String name, boolean isExtra, boolean isPremium, String type) {
        super(name, isExtra, isPremium, type);

        this.smallBase = 0.75;
        this.smallExtra = 0.30;
        this.mediumBase = 1.50;
        this.mediumExtra = 0.60;
        this.largeBase = 2.25;
        this.largeExtra = 0.90;
    }

    @Override
    public double getPrice(Size size) {
        double base = 0;
        double extraCharge = 0;

        if (size == Size.SMALL) {
            base = this.smallBase;
            extraCharge = this.smallExtra;
        } else if (size == Size.MEDIUM) {
            base = this.mediumBase;
            extraCharge = this.mediumExtra;
        } else if (size == Size.LARGE) {
            base = this.largeBase;
            extraCharge = this.largeExtra;
        }

        if (isExtra()) {
            base += extraCharge;
        }

        return base;
    }
}