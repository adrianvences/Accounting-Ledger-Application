package accountingledgerapp;

public class Prompts {

    public static String promptMaker(String prompt) {
        System.out.println(prompt);
        return Screens.scanner.nextLine();
    }

    public String homeScreenPrompt = ("""
                    *Welcome to the Accounting Ledger App*
                     ~ Enter 
                     - D ) To Make a Deposit
                     - P ) To Make a Payment
                     - L ) To View Ledger
                     - X ) To exit. 
                    """);

}
