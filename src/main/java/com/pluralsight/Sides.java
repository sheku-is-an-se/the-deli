package com.pluralsight;

public class Sides extends Ingredient {

    public Sides(String name, boolean isExtra, boolean isPremium, String type) {
        super(name, isExtra, isPremium, type);
    }

    @Override
    public double getPrice(Size size) {
        return 0;
    }
}
