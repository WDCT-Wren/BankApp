package BankApp;

import java.util.ArrayList;
import java.util.Scanner;

public class Transactions {
    static Scanner input = new Scanner(System.in);

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
    
    public static void withdrawal(BankAccount currentAcc) {
        boolean validAmount = false;
        while (validAmount == false) {
            try {
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

