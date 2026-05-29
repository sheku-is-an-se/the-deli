package com.pluralsight;

public class RegularToppings extends Ingredient {
    public RegularToppings(String name, boolean isExtra, boolean isPremium, String type) {
        super(name, isExtra, isPremium, type);
    }

    @Override
    public double getPrice(Size size) {
        return 0;
    }
}
