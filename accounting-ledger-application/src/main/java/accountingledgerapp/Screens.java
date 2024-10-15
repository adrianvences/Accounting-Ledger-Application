package accountingledgerapp;

import java.util.Scanner;

public class Screens {

    // Scanner to read user input from terminal
    static Scanner scanner = new Scanner(System.in);




    //****************************************************//
                   // Home Screen Method //
    public static void homeScreen(){

        // Boolean Flag to exit while loop
        boolean loopFlag = true;

        // While loop to keep home screen iterating through switch cases.
        while(loopFlag){

            // input variable that stores users input through promptMaker method for cleaner code.
            String input = Prompts.promptMaker("""
                    * Welcome to the Accounting Ledger App *
                    -----------------Home-------------------
                     ~ Enter                               -
                     - D ) To Make a Deposit               -
                     - P ) To Make a Payment               -
                     - L ) To View Ledger                  -
                     - X ) To exit                         -
                     ---------------------------------------
                    """);

            // switch case with input toUpperCase for no error due to letter case.
            switch (input.toUpperCase()){

                // Make deposit
                case "D":
                    System.out.println("Make a deposit");
                    break;

                // Make payment
                case "P":
                    System.out.println("Make a payment");
                    break;

                // Ledger view
                case "L":
                    ledgerScreen();
                    break;

                // Exit
                case "X":
                    System.out.println("Exit");
                    loopFlag = false;

                // In case of invalid input. Default gives back an invalid input message.
                default:
                    System.out.println("Invalid input");
            }

        }
    }


    //****************************************************//
                  // Ledger Screen Method //
    public static void ledgerScreen() {

        // Boolean Flag to exit while loop
        boolean loopFlag = true;

        // While loop to keep home screen iterating through switch cases.
        while(loopFlag){

            // input variable that stores users input through promptMaker method for cleaner code.
            String input = Prompts.promptMaker("""
                    -----------* Your Ledger *-------------
                     ~ Enter                              -
                     - A ) All - Display all Transactions -
                     - D ) To View Account Deposits       -
                     - P ) To View Account Payments       -
                     - R ) Reports Menu                   -
                     - H ) Home Screen                    -
                     --------------------------------------
                    """);

            // switch case with input toUpperCase for no error due to letter case.
            switch (input.toUpperCase()){

                // View all Transactions
                case "A":
                    System.out.println("Display all Transactions");
                    break;

                // View Account Deposits
                case "D":
                    System.out.println("To View Account Deposits");
                    break;

                // View Account Payments
                case "P":
                    System.out.println("To View Account Payments");
                    break;

                // Reports Menu
                case "R":
                    System.out.println("Reports Menu");
                    break;

                // Return to Home Screen
                case "H":
                    System.out.println("Returning Home...");
                    loopFlag = false;
                    break;

                    // In case of invalid input. Default gives back an invalid input message.
                default:
                    System.out.println("Invalid input");
            }

        }
    }

             //****************************************************//
                         // Reports Screen Method //

    public static void reportsScreenMethod(){

        // Boolean Flag to exit while loop
        boolean loopFlag = true;

        // While loop to keep home screen iterating through switch cases.
        while(loopFlag){

            // input variable that stores users input through promptMaker method for cleaner code.
            String input = Prompts.promptMaker("""
                    -----------* Your Ledger *-------------
                     ~ Enter                              -
                     - 1 ) Month to Date                  -
                     - 2 ) Previous Month                 -
                     - 3 ) Year to Date                   -
                     - 4 ) Previous Year                  -
                     - 5 ) Search by Vendor               -
                     - 0 ) Back                           -
                     - H ) Home Screen                    -
                     --------------------------------------
                    """);
            // FINISH SWITCH STATEMENTS

            // switch case with input toUpperCase for no error due to letter case.
            switch (input.toUpperCase()){

                // View all Transactions
                case "A":
                    System.out.println("Display all Transactions");
                    break;

                // View Account Deposits
                case "D":
                    System.out.println("To View Account Deposits");
                    break;

                // View Account Payments
                case "P":
                    System.out.println("To View Account Payments");
                    break;

                // Reports Menu
                case "R":
                    System.out.println("Reports Menu");
                    break;

                // Return to Home Screen
                case "H":
                    System.out.println("Returning Home...");
                    loopFlag = false;
                    break;

                // In case of invalid input. Default gives back an invalid input message.
                default:
                    System.out.println("Invalid input");
            }

        }
    }

}
