package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public void homeMenu() {
        String prompt = """
                ╔══════════════════════════════════════════════╗
                ║              THE-DELI SANDWICH SHOP        ║
                ╠══════════════════════════════════════════════╣
                ║         Create and manage customer orders    ║
                ╚══════════════════════════════════════════════╝
                
                                 HOME SCREEN
                ------------------------------------------------
                [1] New Order
                [0] Exit
                ------------------------------------------------
                Enter your choice:\s""";

        boolean running = true;

        do {
            int userMenu = CliUtils.promptForInteger(prompt);


            switch (userMenu) {
                case 1:
                    orderScreen();
                    break;
                case 0:
                    running = false;
                    System.out.println("You have exited the application");
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);

    }

    public void orderScreen() {
        ArrayList<Product> currentOrderItems = new ArrayList<>();

        String prompt = """
                ╔══════════════════════════════════════════════╗
                ║              THE-DELI SANDWICH SHOP          ║
                ╠══════════════════════════════════════════════╣
                ║               Build and manage order         ║
                ╚══════════════════════════════════════════════╝
                
                                 ORDER SCREEN
                ------------------------------------------------
                [1] Add Sandwich
                [2] Add Drink
                [3] Add Chips
                [4] Checkout
                [0] Cancel Order
                ------------------------------------------------
                Enter your choice:\s""";

        boolean running = true;

        do {
            int userMenu = CliUtils.promptForInteger(prompt);


            switch (userMenu) {
                case 1:
                    Sandwich sandwich = sandwichScreen();
                    currentOrderItems.add(sandwich);
                    break;
                case 2:
                    System.out.println("Add Drink");
                    break;
                case 3:
                    System.out.println("Add Chips!");
                    break;
                case 4:
                    System.out.println("Checkout");
                    break;
                case 0:
                    running = false;
                    System.out.println("Cancel order");
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);

    }

    public Sandwich sandwichScreen() {
        //Get the basics first
        String bread = promptForBread();
        Size size = promptForSize();

        //Create the sandwich object
        Sandwich sandwich = new Sandwich("Custom Sandwich", size, bread, false, new ArrayList<>());

        //Add the ingredients using my helpers
        promptForMeat(sandwich);
        promptForCheese(sandwich);
        promptForToppings(sandwich);

        return sandwich;
    }

    //helper method for bread prompt
    public String promptForBread() {
        String bread = """ 
                Select your bread
                
                1) white
                2) wheat
                3) rye
                4) wrap
                5) cancel order""";

        boolean running = true;

        String selection = "";
        do {
            int userMenu = CliUtils.promptForInteger(bread);


            switch (userMenu) {
                case 1:
                    running = false;
                    selection = "white";
                    break;
                case 2:
                    running = false;
                    selection = "wheat";
                    break;
                case 3:
                    running = false;
                    selection = "rye";
                    break;
                case 4:
                    running = false;
                    selection = "wrap";
                    break;
                case 0:
                    running = false;
                    System.out.println("Cancel order");
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);
        return selection;
    }

    public Size promptForSize() {
        String sandwichSize = """
                Select your sandwich size:
                
                1) SMALL
                2) MEDIUM
                3) LARGE
                
                """;

        boolean running = true;

        Size selection = null;
        do {
            int userMenu = CliUtils.promptForInteger(sandwichSize);


            switch (userMenu) {
                case 1:
                    running = false;
                    selection = Size.SMALL;
                    break;
                case 2:
                    running = false;
                    selection = Size.MEDIUM;
                    break;
                case 3:
                    running = false;
                    selection = Size.LARGE;
                    break;
                case 0:
                    running = false;
                    System.out.println("Cancel order");
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);
        return selection;
    }

    public void promptForMeat(Sandwich sandwich) {
        String meat = """
                Select your meat
                
                1) steak
                2) ham
                3) salami
                4) roast beef
                5) chicken
                6) bacon
                0) No meat
                
                """;

        String extra = """
                Do you want extra?
                
                1) yes
                2) no
                """;

        boolean running = true;
        String meatName = "";
        int userMenu;
        do {
            userMenu = CliUtils.promptForInteger(meat);


            switch (userMenu) {
                case 1:
                    meatName = "steak";
                    running = false;
                    break;
                case 2:
                    meatName = "ham";
                    running = false;
                    break;
                case 3:
                    meatName = "salami";
                    running = false;
                    break;
                case 4:
                    meatName = "roast beef";
                    running = false;
                    break;
                case 5:
                    meatName = "chicken";
                    running = false;
                    break;
                case 6:
                    meatName = "bacon";
                    running = false;
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);

        boolean isExtra = false;
        if (userMenu != 0) {
            int extraMeat = CliUtils.promptForInteger(extra);
            if(extraMeat == 1){
                isExtra = true;
            }

            Meat meatObject = new Meat(meatName,isExtra,true,"Meat");
            sandwich.addTopping(meatObject);
        }


    }

    public void promptForCheese(Sandwich sandwich) {
        String cheese = """
                Select your Cheese:
                
                1) american
                2) provolone
                3) cheddar
                4) swiss
                0) No cheese
                
                """;

        String extra = """
                Do you want extra?
                
                1) yes
                2) no
                """;

        boolean running = true;
        String cheeseName = "";
        int userMenu;
        do {
            userMenu = CliUtils.promptForInteger(cheese);


            switch (userMenu) {
                case 1:
                    cheeseName = "american";
                    running = false;
                    break;
                case 2:
                    cheeseName = "provolone";
                    running = false;
                    break;
                case 3:
                    cheeseName = "cheddar";
                    running = false;
                    break;
                case 4:
                    cheeseName = "swiss";
                    running = false;
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);

        boolean isExtra = false;
        if (userMenu != 0) {
            int extraCheese = CliUtils.promptForInteger(extra);
            if(extraCheese == 1){
                isExtra = true;
            }

            Cheese cheeseObject = new Cheese(cheeseName,isExtra,true,"Cheese");
            sandwich.addTopping(cheeseObject);
        }


    }

    public void promptForToppings(Sandwich sandwich){

        String toppings = """
                Select your Toppings:
                
                
                1) lettuce
                2) peppers
                3) onions
                4) tomatoes
                5) jalapeños
                6) cucumbers
                7) pickles
                8) guacamole
                9) mushrooms
                0) Stop adding toppings 
                
                """;

        int userMenu;
        do {
            userMenu = CliUtils.promptForInteger(toppings);

            switch (userMenu) {
                case 1:
                    RegularToppings lettuce = new RegularToppings("lettuce", false,false,"Topping");
                    sandwich.addTopping(lettuce);
                    break;
                case 2:
                    RegularToppings peppers = new RegularToppings("peppers", false,false,"Topping");
                    sandwich.addTopping(peppers);
                    break;
                case 3:
                    RegularToppings onions = new RegularToppings("onions", false,false,"Topping");
                    sandwich.addTopping(onions);
                    break;
                case 4:
                    RegularToppings tomatoes = new RegularToppings("tomatoes", false,false,"Topping");
                    sandwich.addTopping(tomatoes);
                    break;
                case 5:
                    RegularToppings jalapenos = new RegularToppings("jalapenos", false,false,"Topping");
                    sandwich.addTopping(jalapenos);
                    break;
                case 6:
                    RegularToppings cucumbers = new RegularToppings("cucumbers", false,false,"Topping");
                    sandwich.addTopping(cucumbers);
                    break;
                case 7:
                    RegularToppings pickles = new RegularToppings("pickles", false,false,"Topping");
                    sandwich.addTopping(pickles);
                    break;
                case 8:
                    RegularToppings guacamole = new RegularToppings("guacamole", false,false,"Topping");
                    sandwich.addTopping(guacamole);
                    break;
                case 9:
                    RegularToppings mushrooms = new RegularToppings("mushrooms", false,false,"Topping");
                    sandwich.addTopping(mushrooms);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (userMenu != 0);
    }

    public void promptForSauces(Sandwich sandwich){

        String sauces = """
                Select your Sauces:
                
                
                1) mayo
                2) mustard
                3) ketchup
                4) ranch
                5) thousand islands
                6) vinaigrette
                0) Stop adding sauces
                
                """;

        int userMenu;
        do {
            userMenu = CliUtils.promptForInteger(sauces);

            switch (userMenu) {
                case 1:
                    RegularToppings mayo = new RegularToppings("Mayo", false,false,"Sauces");
                    sandwich.addTopping(mayo);
                    break;
                case 2:
                    RegularToppings mustard = new RegularToppings("Mustard", false,false,"Sauces");
                    sandwich.addTopping(mustard);
                    break;
                case 3:
                    RegularToppings ketchup = new RegularToppings("Ketchup", false,false,"Sauces");
                    sandwich.addTopping(ketchup);
                    break;
                case 4:
                    RegularToppings ranch = new RegularToppings("Ranch", false,false,"Sauces");
                    sandwich.addTopping(ranch);
                    break;
                case 5:
                    RegularToppings thousandIslands = new RegularToppings("Thousand Islands", false,false,"Sauces");
                    sandwich.addTopping(thousandIslands);
                    break;
                case 6:
                    RegularToppings vinaigrette = new RegularToppings("Vinaigrette", false,false,"Sauces");
                    sandwich.addTopping(vinaigrette);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (userMenu != 0);
    }


}
