package com.pluralsight;

import java.util.List;

public class Sandwich extends Product {
    private String bread;
    private boolean toasted;
    private List<Ingredient> ingredients;

    private double smallBreadBase;
    private double mediumBreadBase;
    private double largeBreadBase;

    public Sandwich(String name, Size size, String bread, boolean toasted, List<Ingredient> ingredients) {
        super(name, size);
        this.bread = bread;
        this.toasted = toasted;
        this.ingredients = ingredients;

        this.smallBreadBase = 5.50;
        this.mediumBreadBase = 7.00;
        this.largeBreadBase = 8.50;
    }

    public void addTopping(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public double getBreadPrice(Size size) {
        double base = 0;

        if (size == Size.SMALL) {
            base = this.smallBreadBase;
        } else if (size == Size.MEDIUM) {
            base = this.mediumBreadBase;
        } else if (size == Size.LARGE) {
            base = this.largeBreadBase;
        }

        return base;
    }

    @Override
    public double getPrice() {
        double totalPrice = 0;
        Size size = getSize();

        for (Ingredient i : ingredients) {
            totalPrice += i.getPrice(size);
        }

        totalPrice += getBreadPrice(size);

        return totalPrice;
    }
}