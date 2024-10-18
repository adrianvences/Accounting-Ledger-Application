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
                    Prompts.makeDepositPrompt();
                    break;

                // Make payment
                case "P":
                    Prompts.makePaymentPrompt();
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
                    ---------------------------------------
                    """);

            // switch case with input toUpperCase for no error due to letter case.
            switch (input.toUpperCase()){

                // View all Transactions
                case "A":
                    UtilMethods.displayLedgerTransactions();
                    break;

                // View Account Deposits
                case "D":
                    UtilMethods.showDeposits();
                    break;

                // View Account Payments
                case "P":
                    UtilMethods.showPayments();
                    break;

                // Reports Menu
                case "R":
                    reportsScreenMethod();
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
                    -------------* Reports *---------------
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

                // Month to Date Case
                case "1":
                    UtilMethods.monthToDateMethod();
                    break;

                // Previous Month Case
                case "2":
                    UtilMethods.previousMonthMethod();
                    break;

                // Year to Date Case
                case "3":
                    UtilMethods.yearToDateMethod();
                    break;

                // Previous Year Case
                case "4":
                    UtilMethods.previousYearMethod();
                    break;

                // Search by Vendor Case
                case "5":
                    UtilMethods.searchByVendorMethod();
                    break;
                // Back to Ledger Case Screen Case
                case "0":
                    System.out.println("Returning to Reports Screen");
                    loopFlag = false;
                    break;
                // Back to Home Screen Case
                case "H":
                    System.out.println("Returning to Home Screen");
                    loopFlag = false;
                    homeScreen();
                    break;

                // In case of invalid input. Default gives back an invalid input message.
                default:
                    System.out.println("Invalid input");
            }

        }
    }

}
