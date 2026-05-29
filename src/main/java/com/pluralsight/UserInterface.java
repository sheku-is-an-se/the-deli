package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public void homeMenu() {
        String prompt = """
                ╔══════════════════════════════════════════════╗
                ║              THE-DELI SANDWICH SHOP          ║
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
                    promptForSides(currentOrderItems);
                    break;
                case 2:
                    promptForDrinks(currentOrderItems);
                    break;
                case 3:
                    promptForChips(currentOrderItems);
                    break;
                case 4:
                    checkoutSummary(currentOrderItems);

                    FileExporter fileExporter = new FileExporter();
                    fileExporter.saveReceipt(currentOrderItems);
                    currentOrderItems.clear();
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

    public void checkoutSummary(ArrayList<Product> products){
        //Checks if its empty before we print out summary
        if (products.isEmpty()) {
            System.out.println("Your cart is empty! Add some items before checking out.");
            return;
        }

        System.out.println("======================================");
        System.out.println("          CHECKOUT SUMMARY            ");
        System.out.println("======================================");

        double total = 0.0;

        for(Product p: products){
            System.out.println(p);
            total += p.getPrice();
        }
        System.out.println("======================================");
        System.out.println(" TOTAL PRICE: $" + total);
        System.out.println("======================================");

        CliUtils.pause();
    }


    public Sandwich sandwichScreen() {
        //Get the basics first
        String bread = promptForBread();

        if (bread == null) {
            return null;
        }
        Size size = promptForSize();

        //Create the sandwich object
        Sandwich sandwich = new Sandwich("Custom Sandwich", size, bread, false, new ArrayList<>());

        //Add the ingredients using my helpers
        promptForMeat(sandwich);
        promptForCheese(sandwich);
        promptForToppings(sandwich);
        promptForSauces(sandwich);

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
                case 5:
                    running = false;
                    System.out.println("Canceled order");
                    return null;
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

        Meat meatObject;
        if (userMenu != 0) {
            int extraMeat = CliUtils.promptForInteger(extra);
            if(extraMeat == 1){
                //Create the regular meat object
                meatObject = new Meat(meatName, false, true, "Meat");
                sandwich.addTopping(meatObject);
// Create the extra meat object
                meatObject = new Meat(meatName, true, true, "Meat");
                sandwich.addTopping(meatObject);
            }
            if (extraMeat == 2) {
                meatObject = new Meat(meatName,false,true,"Meat");
                sandwich.addTopping(meatObject);
            }

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

        Cheese cheeseObject;
        if (userMenu != 0) {
            int extraCheese = CliUtils.promptForInteger(extra);
            if(extraCheese == 1){
                cheeseObject = new Cheese(cheeseName,false,true,"Cheese");
                sandwich.addTopping(cheeseObject);
                cheeseObject = new Cheese(cheeseName,true,true,"Cheese");
                sandwich.addTopping(cheeseObject);

            }

            if(extraCheese == 2){
                cheeseObject = new Cheese(cheeseName,false,true,"Cheese");
                sandwich.addTopping(cheeseObject);
            }

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

    public void promptForChips(List<Product> multiChips){
        String chips = """
                Select your chips
                
                1) bbq
                2) sour cream and onion
                3) salt and vinegar
                4) classic
                5) cheddar
                0) No chips
                
                """;

        String extra = """
                Would you like more than one bag of chips?
                
                1) yes
                2) no
                """;

        String extraQuantity = "Choose your quantity (1-10): ";

        boolean running = true;
        String chipName = "";
        int userMenu;

        do {
            userMenu = CliUtils.promptForInteger(chips);

            switch (userMenu) {
                case 1:
                    chipName = "bbq";
                    running = false;
                    break;
                case 2:
                    chipName = "sour cream and onion";
                    running = false;
                    break;
                case 3:
                    chipName = "salt and vinegar";
                    running = false;
                    break;
                case 4:
                    chipName = "classic";
                    running = false;
                    break;
                case 5:
                    chipName = "cheddar";
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

        if (userMenu != 0) {
            int quantity = 1;
            int extraChips = CliUtils.promptForInteger(extra);

            if (extraChips == 1) {
                quantity = CliUtils.promptForInteger(extraQuantity);
            }

            for (int i = 0; i < quantity; i++) {
                Chips chip = new Chips(chipName, Size.NONE, "Chips");
                multiChips.add(chip);
            }
        }
    }

    public void promptForDrinks(List<Product> multiDrinks){
        String drinks = """
            Would you like a drink?
            
            1) Yes
            2) No
            """;

        String sizeMenu = """
            What size drink would you like?
            
            1) SMALL
            2) MEDIUM
            3) LARGE
            """;

        String extra = """
            Would you like more than one cup?
            
            1) yes
            2) no
            """;

        String extraQuantity = "Choose your quantity (1-10): ";

        boolean running = true;
        int userMenu;
        do {
            userMenu = CliUtils.promptForInteger(drinks);

            switch (userMenu) {
                case 1:
                    running = false;
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);

        if (userMenu != 2) {
            // If they select "yes", then prompt user for size
            boolean pickingSize = true;
            Size chosenSize = Size.NONE;

            do {
                int sizeChoice = CliUtils.promptForInteger(sizeMenu);
                switch (sizeChoice) {
                    case 1:
                        chosenSize = Size.SMALL;
                        pickingSize = false;
                        break;
                    case 2:
                        chosenSize = Size.MEDIUM;
                        pickingSize = false;
                        break;
                    case 3:
                        chosenSize = Size.LARGE;
                        pickingSize = false;
                        break;
                    default:
                        System.out.println("Oops! That wasn't a valid size.");
                        break;
                }
            } while (pickingSize);

            //Handle quantity
            int quantity = 1;
            int extraDrinks = CliUtils.promptForInteger(extra);

            if (extraDrinks == 1) {
                quantity = CliUtils.promptForInteger(extraQuantity);
            }

            //Create and add drinks
            for (int i = 0; i < quantity; i++) {
                Drinks drink = new Drinks("Drink", chosenSize, "Drink");
                multiDrinks.add(drink);
            }
        }
    }

    public void promptForSides(List<Product> multiSides){
        String sides = """
                Sides
                - au jus
                - sauce
                
                Do you want to have sides included?
                
                1) Yes
                2) No
                """;

        boolean running = true;
        String sideName = "";
        Sides side;
        int userMenu;

        do {
            userMenu = CliUtils.promptForInteger(sides);

            switch (userMenu) {
                case 1:
                    sideName = "au jus";
                    side = new Sides("au jus",Size.NONE);
                    multiSides.add(side);
                    side = new Sides("sauce",Size.NONE);
                    multiSides.add(side);
                    running = false;
                    break;
                case 2:
                    running = false;
                    break;
                default:
                    System.out.println("Oops! That wasn't a valid option.");
                    break;
            }
        } while (running);


    }



}
