package com.pluralsight;

import java.util.List;

public class Sandwich extends Product {
    private String bread;
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(String bread, boolean toasted, List<Topping> toppings,String name, String size) {
        super(name,size);
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
