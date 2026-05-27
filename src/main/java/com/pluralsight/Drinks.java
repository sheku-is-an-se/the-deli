package com.pluralsight;

public class Drinks extends Product {
    private String flavor;

    public Drinks(String size, String flavor, String type) {
        super("Drink", size, type);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public double getPrice() {
        switch (this.getSize().toLowerCase()) {
            case "small":
                return 2.00;
            case "medium":
                return 2.50;
            case "large":
                return 3.00;
            default:
                return 0.0;
        }
    }
}
