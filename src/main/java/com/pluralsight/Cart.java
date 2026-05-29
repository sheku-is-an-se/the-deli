package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product product) {
        items.add(product);
    }

    public double getTotalPrice() {
        double total = 0;

        for (Product p : items) {
            total += p.getPrice();
        }

        return total;
    }

    public List<Product> getItems() {
        return items;
    }
}
