package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserInterface userInterface = new UserInterface();
        userInterface.homeMenu();

        Meat meat = new Meat("steak","Small",true,true,"wagyu");
        Cheese cheese = new Cheese("american", "small",true,true,"melted");
        List<Ingredient> ingredients = new ArrayList<>();

        //ingredients.add(meat);
        //ingredients.add(cheese);



        //Sandwich sandwich = new Sandwich("Sandwich","small", "white", true, ingredients);
        //System.out.println(sandwich.getPrice());
    }
}