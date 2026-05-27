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
            int userMenu = PromptParsing.promptForInteger(prompt);


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
            int userMenu = PromptParsing.promptForInteger(prompt);


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

    public void sandwichScreen() {
        String prompt = """
                ╔══════════════════════════════════════════════╗
                ║                 THE-DELI                     ║
                ╠══════════════════════════════════════════════╣
                ║            Customize your sandwich           ║
                ╚══════════════════════════════════════════════╝
                
                                ADD SANDWICH
                ------------------------------------------------
                Follow the steps to build your sandwich.
                ------------------------------------------------
                """;

        boolean running = true;

        do {
            int userMenu = PromptParsing.promptForInteger(prompt);


            switch (userMenu) {
                case 1:
                    System.out.println("Add Sandwich!");
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
}
