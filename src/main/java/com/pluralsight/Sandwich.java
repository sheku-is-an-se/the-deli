package com.pluralsight;

import java.util.List;

public class Sandwich extends Product {
    private String bread;
    private boolean toasted;
    private List<Topping> toppings;

    public Sandwich(String size, String type, String bread, boolean toasted, List<Topping> toppings) {
        super("Sandwich",size,type);
        this.bread = bread;
        this.toasted = toasted;
        this.toppings = toppings;
    }


    @Override
    public double getPrice() {
        if (this.getSize().equals("4")){
            return 5.50;
        } else if (this.getSize().equals("8")) {
            return 7.50;

        } else if (this.getSize().equals("12")) {
            return 9.50;

        }

        return 0.0;
    }
}
