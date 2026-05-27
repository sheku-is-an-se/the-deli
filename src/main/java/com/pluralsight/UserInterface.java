package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);

    public void homeMenu() {
        String prompt = """
                ╔══════════════════════════════════════════════╗
                ║              DELI-CIOUS SANDWICH SHOP        ║
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
                    System.out.println("New Order!");
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
                ║              DELI-CIOUS SANDWICH SHOP        ║
                ╠══════════════════════════════════════════════╣
                ║         Create and manage customer orders    ║
                ╚══════════════════════════════════════════════╝
                
                                 ORDER SCREEN
                ------------------------------------------------
                [1] Add Sandwich
                [2] Add Drink
                [3] Add Chips
                [4] Add Drink
                ------------------------------------------------
                Enter your choice:\s""";

        boolean running = true;

        do {
            int userMenu = PromptParsing.promptForInteger(prompt);


            switch (userMenu) {
                case 1:
                    System.out.println("New Order!");
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
}
