package com.pluralsight;

public class Cheese extends Ingredient {

    public Cheese(String name, boolean isExtra, boolean isPremium, String type) {
        super(name, isExtra, isPremium, type);
    }

    public double getPrice(CheeseSize size){

        double cheesePrice = size.getBasePrice();
        if(isExtra()){
            cheesePrice += size.getExtra();
        }


        return cheesePrice;
    }
}
