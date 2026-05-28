package com.pluralsight;

import java.util.HashMap;
import java.util.Map;

public class Meat extends Ingredient {

    private double smallBase;
    private double smallExtra;
    private double mediumBase;
    private double mediumExtra;
    private double largeBase;
    private double largeExtra;

    public Meat(String name, boolean isExtra, boolean isPremium, String type) {
        super(name, isExtra, true, type);

        this.smallBase = 1.00;
        this.smallExtra = 0.50;
        this.mediumBase = 2.00;
        this.mediumExtra = 1.00;
        this.largeBase = 3.00;
        this.largeExtra = 1.50;
    }



    public double getPrice(Size size){

       double base = 0;
       double extraCharge = 0;

        if(size == Size.SMALL){
            base = this.smallBase;
            extraCharge = this.smallExtra;
        } else if (size == Size.MEDIUM) {
            base = this.mediumBase;
            extraCharge = this.mediumExtra;

        } else if (size == Size.LARGE) {
            base = this.largeBase;
            extraCharge = this.largeExtra;

        }

        if(isExtra()){
            base += extraCharge;
        }


        return base;
    }
}
