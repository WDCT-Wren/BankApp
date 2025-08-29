package BankApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Transactions {
    static Scanner input = new Scanner(System.in);

    //Method for depositing cash into an account's savings.
    public static void deposit(BankAccount currentAcc) {
        boolean validAmount = false; 
        while (validAmount == false) {
            try {
                System.out.print("ENTER AMOUNT DEPOSITED: ");
                double amount = input.nextDouble();
                
                if (amount < 0){
                    System.out.println("INVALID AMOUNT! Please enter a non-negative amount.");
                    input.nextLine();
                }
                else{
                    currentAcc.deposit(amount);
                    validAmount = true;
                }
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("INVALID AMOUNT! Please enter a valid amount(in numerical form).");
                input.nextLine();
            }
        }
    }

    //Registration menu method that will be called when the user wants to register a new account
    public static ArrayList<BankAccount> showRegistrationMenu() {
        //Reistration logic
        String name;
        while (true) {
            System.out.print("ENTER NAME: ");
            name = input.nextLine();
            if (name.matches("^[a-zA-Z ]+$")) {break;} //Regex checks the name inputted if it matches with the following (if its a-z or A-Z and if there are spaces)
            System.out.println("INVALID NAME! Please only use letters and spaces.");
        }

            BankAccount newAccount = new BankAccount(name); //Makes a new object iteration of the bank account with the corresponding name
            int newAccountNumber = newAccount.getAccountNumber();

            Main.accounts.add(newAccount); //adds the account to the BankAccount Arraylists inside the Main itself
            
            System.out.println("ACCOUNT REGISTERD SUCCESSFULLY");
            System.out.println("YOUR REGISTERED ACCOUNT NUMBER: " + newAccountNumber);
        return Main.accounts;
    }

    //Method to show the user the Logged in accounts.
    public static void showLogIn() {
        System.out.println("AVAILABLE ACCOUNTS: ");
            for (BankAccount acc : Main.accounts) {
                System.out.println("Account number: " + acc.getAccountNumber() + "|| Owner: " + acc.getOwnerName());
            }

            //Choose what account shall be used
            System.out.print("ENTER ACCOUNT NUMBER TO PROCEED: ");
            int enteredAcc = input.nextInt();
            input.nextLine();
            
            BankAccount currentAcc = null;
            
            for (BankAccount acc : Main.accounts){ //utilizes a for loop to pass through all existing accounts in the arraylist account and checks and processes each one accordingly
                if (acc.getAccountNumber() == enteredAcc) { //if one iteration of the arraylists of account numbersmatches the entered account, that entered account will now be assigned to the current account, which simply "logs you in" to that iteration of accounts.
                    currentAcc = acc;
                    break;
                };
            }

            // if there are still no accounts in the array list, any input will show this.
            if (currentAcc == null){
                System.out.println("ACCOUNT NOT FOUND!");
            }
            // if there are existing accounts in the array list, it will follow then the for loop thing.
            else {
                System.out.println("LOGIN SUCCESSFUL FOR: " + currentAcc.getOwnerName()); //includes the user name to validate the user passed.
                //calls the main menu method
                Main.showMainMenu(currentAcc);
            }
    }
    
    //Method to widthraw funds from an account
    public static void withdrawal(BankAccount currentAcc) {
        boolean validAmount = false;
        while (validAmount == false) {
            try { //Validates the user's input
                System.out.print("ENTER WITHDRAWAL AMOUNT: ");
                double amount = input.nextDouble();
                if (amount < 0) {
                    System.out.println("INVALID AMOUNT! Please enter a non-negative amount.");
                    input.nextLine();
                }
                else if (amount > currentAcc.showBalance()) {
                    System.out.println("INSUFFICIENT BALANCE!");
                    input.nextLine();
                }
                else {
                    currentAcc.withdraw(amount);
                    validAmount = true;
                }
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("INVALID AMOUNT! Please enter a valid amount(in numerical form).");
                input.nextLine();
            }
        }
    }
}

