package com.pluralsight;

public abstract class Ingredient {

    private String name;
    private boolean isExtra;
    private boolean isPremium;
    private String type;

    public Ingredient(String name, boolean isExtra, boolean isPremium, String type) {
        this.name = name;
        this.isExtra = isExtra;
        this.isPremium = isPremium;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return isExtra;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public String getType() {
        return type;
    }
}
