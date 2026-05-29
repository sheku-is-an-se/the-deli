package com.pluralsight;

import java.util.List;

public class Sandwich extends Product {
    private String bread;
    private boolean toasted;
    private final List<Ingredient> ingredients;

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
        boolean alreadyOnSandwich = false;

        // Looks at each ingredient currently on the sandwich
        for (Ingredient currentTopping : ingredients) {
            //currenttoppins represent an ingredient that is already in the ingredients list
            //ingredient is self explanatory
            if (currentTopping.getName().equalsIgnoreCase(ingredient.getName()) && !ingredient.isExtra()) {
                alreadyOnSandwich = true;
            }
        }

        //duplicate checks
        if (alreadyOnSandwich) {
            System.out.println("Yo, what's up with the " + ingredient.getName() + "? " + "Lettuce escort you out of our sandwich shop.");
        } else {
            this.ingredients.add(ingredient);
        }
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

    @Override
    public String toString() {
        String details = "Custom Sandwich\n";
        details = details + "  - " + getSize() + " " + bread + ": $" + getBreadPrice(getSize()) + "\n";


        details = details + "  - Toasted: " + toasted + "\n";

        for (Ingredient topping : ingredients) {
            // Calulates price based on sandwich size
            double toppingPrice = topping.getPrice(getSize());

            // prints the name and price together
            details = details + "  - " + topping.getName() + ": $" + toppingPrice + "\n";
        }

        return details;
    }
}