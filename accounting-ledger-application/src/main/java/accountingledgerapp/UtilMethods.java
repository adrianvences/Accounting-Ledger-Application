package accountingledgerapp;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

public class UtilMethods {
    // Transactions ArrayList to Store Ledger Information
    static ArrayList<Transaction> transactionsList = new ArrayList<>();

    // Write to file method
    public static void ledgerWriterMethod(String input){

        BufferedWriter buffWriter = null;
        try {
            // File writer to create file and set append to true so we do not overwrite file
            FileWriter fileWriter = new FileWriter("transactions.csv", true);

            // Helps fileWriter write to file by buffering data
            buffWriter = new BufferedWriter(fileWriter);
            // Writes input given
            buffWriter.write(input);
            // Inserts new line
            buffWriter.newLine();
            // Closes buffWriter to prevent
            buffWriter.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // Make a deposit method
    // will take a string
    // must parce string
    // must add string to csv file
    // must add string to transactionsList
    public static void makeDepositMethod(String input){
        String[] depositInfo = input.split(",");

    }






}
