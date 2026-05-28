package com.pluralsight;

public class Meat extends Ingredient {


    public Meat(String name, boolean isExtra, boolean isPremium, String type) {
        super(name, isExtra, true, type);
    }



    public double getPrice(MeatSize size){

        double meatPrice = size.getBasePrice();
        if(isExtra()){
            meatPrice += size.getExtra();
        }


        return meatPrice;
    }
}
