package accountingledgerapp;


import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class UtilMethods {
    // Transactions ArrayList to Store Ledger Information
    static ArrayList<String> transactionsList = new ArrayList<>();
    static ArrayList<String> ledgerArray = new ArrayList<>();


    // Adds to transactionList array
    public static ArrayList<String> loadTransactions() throws IOException {


            //FileReader to specify file location and read file
            transactionsList.clear();
            FileReader fileReader = new FileReader("transactions.csv");
            // Buffered Reader to help read more lines of text
            BufferedReader buffReader = new BufferedReader(fileReader);
            String input;
            while ((input = buffReader.readLine()) != null) {
                transactionsList.add(input);
            }
            buffReader.close();
            return transactionsList;

    }

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
                // Closes buffWriter to prevent
                buffWriter.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    // This method reads from the csv file and displays all transactions
    public static void displayLedgerTransactions(){
            try {
                newestToOldestTransaction(loadTransactions());
            } catch (IOException i) {
                i.printStackTrace();
            }
    }



    // Method to show Deposits only.
    public static void showDeposits(){
        try {
            // Holds deposit transactions
            ArrayList<String> depositsArray = new ArrayList<>();
            // Loads transactions
            ArrayList<String> transactions = loadTransactions();
            // Adds Header
            depositsArray.add(transactions.get(0));
            // Loops through transactions skips header
            for(int i = 1;i < transactions.size();i++){
                String transaction = transactions.get(i);
                String[] transactionParts = transaction.split("\\|");
                double amountParser = Double.parseDouble(transactionParts[4]);
                if(amountParser > 0) {
                    depositsArray.add(transaction);
                }
            }
            // sorts depositArray newest to oldest.
            newestToOldestTransaction(depositsArray);
            depositsArray.clear();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error here");
        }
    }

    public static void showPayments(){
        try {
            // Holds deposit transactions
            ArrayList<String> paymentsArray = new ArrayList<>();
            // Loads transactions
            ArrayList<String> transactions = loadTransactions();
            // Adds Header
            paymentsArray.add(transactions.get(0));
            // Loops through transactions skips header
            for(int i = 1;i < transactions.size();i++){
                String transaction = transactions.get(i);
                String[] transactionParts = transaction.split("\\|");
                double amountParser = Double.parseDouble(transactionParts[4]);
                if(amountParser < 0) {
                    paymentsArray.add(transaction);
                }
            }
            // sorts depositArray newest to oldest.
            newestToOldestTransaction(paymentsArray);
            paymentsArray.clear();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error here");
        }
    }


    public static void newestToOldestTransaction(ArrayList<String> arrayList) {
        System.out.println(arrayList.get(0));
        for (int i = arrayList.size() - 1; i >= 1; i--) {
            System.out.println(arrayList.get(i));
        }
    }

    public static void monthToDateMethod(){
        // Loads transactions
        try {
            ArrayList<String> monthToDateArray = new ArrayList<>();
            ArrayList<String> transactions = loadTransactions();
            monthToDateArray.add(transactions.get(0));
            for (int i = 1;i < transactions.size();i++) {
                String transaction = transactions.get(i);
                String[] transactionSplit = transactions.get(i).split("\\|");
                String[] dateSplit = transactionSplit[0].split("-");
                int month = Integer.parseInt(dateSplit[1]);
                if(month == Prompts.month) {
                    monthToDateArray.add(transaction);
                }
            }
            newestToOldestTransaction(monthToDateArray);
            monthToDateArray.clear();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void previousMonthMethod(){
        // Loads transactions
        try {
            ArrayList<String> previousMonthArray = new ArrayList<>();
            ArrayList<String> transactions = loadTransactions();
            previousMonthArray.add(transactions.get(0));
            for (int i = 1;i < transactions.size();i++) {
                String transaction = transactions.get(i);
                String[] transactionSplit = transactions.get(i).split("\\|");
                String[] dateSplit = transactionSplit[0].split("-");
                int month = Integer.parseInt(dateSplit[1]);
                if((month) == (Prompts.month - 1)) {
                    previousMonthArray.add(transaction);
                }
            }
            newestToOldestTransaction(previousMonthArray);
            previousMonthArray.clear();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void yearToDateMethod(){
        // Loads transactions
        try {
            ArrayList<String> yearToDateArray = new ArrayList<>();
            ArrayList<String> transactions = loadTransactions();
            yearToDateArray.add(transactions.get(0));
            for (int i = 1;i < transactions.size();i++) {
                String transaction = transactions.get(i);
                String[] transactionSplit = transactions.get(i).split("\\|");
                String[] dateSplit = transactionSplit[0].split("-");
                int year = Integer.parseInt(dateSplit[0].trim());
                if((year) == (Prompts.year)) {
                    yearToDateArray.add(transaction);
                }
            }
            newestToOldestTransaction(yearToDateArray);
            yearToDateArray.clear();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void previousYearMethod(){
        // Loads transactions
        try {
            ArrayList<String> previousYearArray = new ArrayList<>();
            ArrayList<String> transactions = loadTransactions();
            previousYearArray.add(transactions.get(0));
            for (int i = 1;i < transactions.size();i++) {
                String transaction = transactions.get(i);
                String[] transactionSplit = transactions.get(i).split("\\|");
                String[] dateSplit = transactionSplit[0].split("-");
                int year = Integer.parseInt(dateSplit[0].trim());
                if((year) == (Prompts.year - 1)) {
                    previousYearArray.add(transaction);
                }
            }
            newestToOldestTransaction(previousYearArray);
            previousYearArray.clear();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void searchByVendorMethod(){
        // Loads transactions
        try {
            String vendorName = Prompts.promptMaker("Please enter vendors name you want to query.");
            ArrayList<String> vendorTransactionArray = new ArrayList<>();
            ArrayList<String> transactions = loadTransactions();
            vendorTransactionArray.add(transactions.get(0));
            for (int i = 1;i < transactions.size();i++) {
                String transaction = transactions.get(i);
                String[] transactionSplit = transactions.get(i).split("\\|");
                String vendorNameData = transactionSplit[3].trim();
                if(vendorName.equalsIgnoreCase(vendorNameData)) {
                    vendorTransactionArray.add(transaction);
                }
            }
            newestToOldestTransaction(vendorTransactionArray);
            vendorTransactionArray.clear();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }





}
