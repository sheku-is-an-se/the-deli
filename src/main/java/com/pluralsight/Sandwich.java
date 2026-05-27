package com.pluralsight;

import java.util.List;

public class Sandwich extends Product {
    private String bread;
    private boolean toasted;
    private List<Ingredient> ingredients;

    public Sandwich(String size, String bread, boolean toasted, List<Ingredient> ingredients) {
        super("Sandwich", size);
        this.bread = bread;
        this.toasted = toasted;
        this.ingredients = ingredients;
    }

    public void addTopping(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    @Override
    public double getPrice() {
        if (this.getSize().equals("4")) {
            return 5.50;
        } else if (this.getSize().equals("8")) {
            return 7.50;

        } else if (this.getSize().equals("12")) {
            return 9.50;

        }

        return 0.0;
    }
}
