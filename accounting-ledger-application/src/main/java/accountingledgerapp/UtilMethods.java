package accountingledgerapp;
import java.io.*;
import java.util.ArrayList;

public class UtilMethods {
    // Transactions ArrayList to Store Ledger Information
    static ArrayList<Transaction> transactionsList = new ArrayList<>();
    static ArrayList<String> ledgerArray = new ArrayList<>();


    // working on making this load objects
    // Adds to transactionList array
    public static ArrayList<Transaction> loadTransactions() throws IOException {


            //FileReader to specify file location and read file
            transactionsList.clear();
            FileReader fileReader = new FileReader("transactions.csv");
            // Buffered Reader to help read more lines of text
            BufferedReader buffReader = new BufferedReader(fileReader);
            String input;
            buffReader.readLine();

            while ((input = buffReader.readLine()) != null) {
                String[] transactionSplit = input.split("\\|");
                double amount = Double.parseDouble(transactionSplit[4]);
                try {
                    transactionsList.add(new Transaction(transactionSplit[0], transactionSplit[1], transactionSplit[2], transactionSplit[3],amount));
                } catch (NumberFormatException n) {
                    n.printStackTrace();
                }
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
            ArrayList<Transaction> depositsArray = new ArrayList<>();
            // Loads transactions
            ArrayList<Transaction> transactions = loadTransactions();
            // Loops through transactions skips header
            for (Transaction transaction : transactions) {
                double amount = transaction.getAmount();
                if (amount > 0) {
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
            ArrayList<Transaction> paymentsArray = new ArrayList<>();
            // Loads transactions
            ArrayList<Transaction> transactions = loadTransactions();
            // Loops through transactions skips header
            for (Transaction transaction : transactions) {
                double amount = transaction.getAmount();
                if (amount < 0) {
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


    public static void newestToOldestTransaction(ArrayList<Transaction> transactionsArrayList) {
//        System.out.println(transactionsArrayList.get(0));
        System.out.println("    Date      |    Time    |    Description   |   Vendor   |   Amount");
        System.out.println(" --------------------------------------------------------------------");
        for (int i = transactionsArrayList.size() - 1; i >= 0; i--) {
            System.out.println(transactionsArrayList.get(i));
        }
    }

    public static void monthToDateMethod(){
        // Loads transactions
        try {
            ArrayList<Transaction> monthToDateArray = new ArrayList<>();
            ArrayList<Transaction> transactions = loadTransactions();
            for (Transaction transaction : transactions) {
                String[] dateSplit = transaction.getDate().split("-");
                int month = Integer.parseInt(dateSplit[1]);
                if (month == Prompts.month) {
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
            ArrayList<Transaction> previousMonthArray = new ArrayList<>();
            ArrayList<Transaction> transactions = loadTransactions();
            for (Transaction transaction : transactions) {
                String[] dateSplit = transaction.getDate().split("-");
                int month = Integer.parseInt(dateSplit[1]);
                if ((month) == (Prompts.month - 1)) {
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
            ArrayList<Transaction> yearToDateArray = new ArrayList<>();
            ArrayList<Transaction> transactions = loadTransactions();
            for (Transaction transaction : transactions) {
                String[] dateSplit = transaction.getDate().split("-");
                int year = Integer.parseInt(dateSplit[0].trim());
                if ((year) == (Prompts.year)) {
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
            ArrayList<Transaction> previousYearArray = new ArrayList<>();
            ArrayList<Transaction> transactions = loadTransactions();
            for (Transaction transaction : transactions) {
                String[] dateSplit = transaction.getDate().split("-");
                int year = Integer.parseInt(dateSplit[0].trim());
                if ((year) == (Prompts.year - 1)) {
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
            ArrayList<Transaction> vendorTransactionArray = new ArrayList<>();
            ArrayList<Transaction> transactions = loadTransactions();
            for (Transaction transaction : transactions) {
                String vendorNameData = transaction.getVendor().trim();
                if (vendorName.equalsIgnoreCase(vendorNameData)) {
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
