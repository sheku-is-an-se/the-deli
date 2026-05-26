package com.pluralsight;

public class Drinks extends Product {
    private String flavor;

    public Drinks(String size, String flavor) {
        super("Drink", size);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
