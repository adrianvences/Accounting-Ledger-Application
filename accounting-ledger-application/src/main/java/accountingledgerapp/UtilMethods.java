package accountingledgerapp;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class UtilMethods {
    // Transactions ArrayList to Store Ledger Information
    static ArrayList<Transaction> transactionsList = new ArrayList<>();

    // This method writes to the csv file
    public static void ledgerWriterMethod(String input){

        BufferedWriter buffWriter = null;
        try {
            // file variable to save file name
            File file = new File("transactions.csv");
            // checks to see if file does not exist evaluates to true ,or it checks to see if file is empty
            boolean isNewFile = !file.exists() || file.length() == 0;
            // fileWriter to create file and append
            FileWriter fileWriter = new FileWriter(file, true);
            // Helps fileWriter write to file by buffering data
            buffWriter = new BufferedWriter(fileWriter);
            // checks if isNewFile is true and if it is it will add a header
            if(isNewFile){
                buffWriter.write("Date | Time | Description | Vendor | Amount");
                buffWriter.newLine();

            }

                // Writes input given
                buffWriter.write(input);
                // Inserts new line
//                buffWriter.newLine();
                // Closes buffWriter to prevent
                buffWriter.close();
//            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // This method reads from the csv file
    public static void displayLedgerTransactions(){

        try {
            //FileReader to specify file location and read file
            FileReader fileReader = new FileReader("transactions.csv");
            // Buffered Reader to help read more lines of text
            BufferedReader buffReader = new BufferedReader(fileReader);

            // This skips over header line to prevent error
//            String header = buffReader.readLine();

            String input;
            while ((input = buffReader.readLine()) != null) {
                System.out.println(input);
            }
            buffReader.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }






}
