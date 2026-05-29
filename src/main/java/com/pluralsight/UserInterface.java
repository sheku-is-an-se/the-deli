package com.pluralsight;

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
                    sandwichScreen();
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

    public String sandwichScreen() {
        String bread = """ 
                Select your bread
                
                1) white
                2) wheat
                3) rye
                4) wrap
                5) cancel order""";

        String sandwichSize = """
                Select your sandwich size:
                
                1) SMALL
                2) MEDIUM
                3) LARGE
                
                """;

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

        String cheese = """
                Select your Cheese:
                
                1) american
                2) provolone
                3) cheddar
                4) swiss
                0) No cheese
                
                """;

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

        boolean running = true;

        String selection = "";
        do {
            int userMenu = CliUtils.promptForInteger(bread);


            switch (userMenu) {
                case 1:
                    running = false;
                    selection = "white";
                    scanner.nextLine();
                    System.out.println(sandwichSize);
                    break;
                case 2:
                    running = false;
                    selection = "wheat";
                    scanner.nextLine();
                    System.out.println(sandwichSize);
                    break;
                case 3:
                    running = false;
                    selection = "rye";
                    scanner.nextLine();
                    System.out.println(sandwichSize);
                    break;
                case 4:
                    running = false;
                    selection = "wrap";
                    scanner.nextLine();
                    System.out.println(sandwichSize);
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
    public String promptForBread(){
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

}
