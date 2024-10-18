package accountingledgerapp;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Prompts {
    // Date and Time stamp variables
    static LocalDateTime today = LocalDateTime.now();
    static DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    static DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
    static String timeStamp = today.format(time);
    static String dateStamp = today.format(date);
    static int month = Integer.parseInt(dateStamp.split("-")[1]);
    static int year = Integer.parseInt(dateStamp.split("-")[0]);

    // method for input that takes a prompt and prints it out and returns output
    public static String promptMaker(String prompt) {
        // prints prompt
        System.out.println(prompt);
        // returns my output
        return Screens.scanner.nextLine();
    }

    // Deposit method along with prompt
    public static void makeDepositPrompt(){
        // Gets current date and time for transactions
        String date  = dateStamp;
        String time =  timeStamp;

        // Prompts users for deposit description and stores it.
        String description = promptMaker("Type in a description for this deposit.");
        // Prompts user for vendor name for deposit and stores it
        String vendor = promptMaker("Type in Vendor Name for this deposit.");
        // Parses users deposit input into a double
        double depositParsed = Double.parseDouble( promptMaker("Insert Deposit Amount" ));

        // Makes a new instance of Transaction class and assigns values using constructor
        Transaction transaction = new Transaction(date,time,description,vendor,depositParsed);
        // Adds transaction object to transactionList ArrayList
//        UtilMethods.transactionsList.add(transaction);
        // Formats Deposit data String
        String transactionData = String.format(" %s | %s | %s | %s | %.2f \n",
                transaction.getDate(), transaction.getTime(),transaction.getDescription(),transaction.getVendor(),transaction.getAmount());
        // Writes String to csv file.
        UtilMethods.ledgerWriterMethod(transactionData);
    }

    // PaymentMethod along with prompt
    public static void makePaymentPrompt(){
        // Gets current date and time for transactions
        String date  = dateStamp;
        String time =  timeStamp;

        // Prompts users for payment description and stores it.
        String description = promptMaker("Type in a Description for this Payment.");
        // Prompts user for vendor name for payment and stores it
        String vendor = promptMaker("Type in Vendor Name for this Payment.");
        // Parses users payment input into a negative double
        double paymentParced = -Double.parseDouble( promptMaker("Insert payment Amount" ));

        // Makes a new instance of Transaction class and assigns values using constructor
        Transaction transaction = new Transaction(date,time,description,vendor,paymentParced);
        // Adds transaction object to transactionList ArrayList
//        UtilMethods.transactionsList.add(transaction);
        // Formats payment data String
        String transactionData = String.format(" %s | %s | %s | %s | %.2f \n",
                transaction.getDate(), transaction.getTime(),transaction.getDescription(),transaction.getVendor(),transaction.getAmount());
        // Writes String to csv file.
        UtilMethods.ledgerWriterMethod(transactionData);
    }





}
