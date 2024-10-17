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

    // method for input that takes a prompt and prints it out and returns output
    public static String promptMaker(String prompt) {
        // prints prompt
        System.out.println(prompt);
        // returns my output
        return Screens.scanner.nextLine();
    }

    public static void makeDepositPrompt(){
        String[] depositInfo = new String[5];
        String date = depositInfo[0] = dateStamp;
        String time = depositInfo[1] = timeStamp;
        String description = depositInfo[2] = promptMaker("Type in a description of this transaction.");
        String vendor = depositInfo[3] = promptMaker("Type in Vendor Name.");
        double depositParce = Double.parseDouble(depositInfo[4] = promptMaker("Insert Deposit Amount" ));

        Transaction transaction = new Transaction(date,time,description,vendor,depositParced);
        UtilMethods.transactionsList.add(transaction);
        String transactionData = String.format(" %s | %s | %s | %s | %.2f \n",
                transaction.getDate(), transaction.getTime(),transaction.getDescription(),transaction.getVendor(),transaction.getAmount());
        UtilMethods.ledgerWriterMethod(transactionData);
    }

//    public String homeScreenPrompt = ("""
//                    *Welcome to the Accounting Ledger App*
//                     ~ Enter
//                     - D ) To Make a Deposit
//                     - P ) To Make a Payment
//                     - L ) To View Ledger
//                     - X ) To exit.
//                    """);

}
