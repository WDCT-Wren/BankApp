package SaveUp;

import java.util.ArrayList;
import java.util.Scanner;

public class Transactions {
    static Scanner input = new Scanner(System.in);

    //Method for depositing cash into an account's savings.
    public static void deposit(SavingsPocket currentPocket) {
        boolean validAmount = false; 
        while (!validAmount) {
            try {
                System.out.print("ENTER AMOUNT DEPOSITED: ");
                double amount = input.nextDouble();
                
                if (amount < 0){
                    System.out.println("INVALID AMOUNT! Please enter a non-negative amount.");
                    input.nextLine();
                }
                else{
                    currentPocket.deposit(amount);
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
    public static ArrayList<SavingsPocket> showAddPocketMenu() {
        //Reistration logic
        String name;
        String password;
        while (true) {
            System.out.print("ENTER POCKET NAME: ");
            name = input.nextLine();
            System.out.print("ENTER A NEW POCKET KEY:");
            password = input.nextLine();
            if (name.matches("^[a-zA-Z ]+$")) {break;} //Regex checks the name inputted if it matches with the following (if its a-z or A-Z and if there are spaces)
            System.out.println("INVALID NAME! Please only use letters and spaces.");
        }
            SavingsPocket newAccount = new SavingsPocket(name, password); //Makes a new object iteration of the bank account with the corresponding name, and password for security purposes
            int newAccountNumber = newAccount.getAccountNumber();

            Main.accounts.add(newAccount); //adds the account to the SavingsPocket Arraylists inside the Main itself
            
            System.out.println("POCKET ADDED SUCCESSFULLY");
            System.out.println("YOUR NEW POCKET NUMBER: " + newAccountNumber);
        return Main.accounts;
    }

    //Method to show the user the Logged in accounts.
    public static void showLogIn() {
        System.out.println("AVAILABLE POCKETS: ");
            for (SavingsPocket acc : Main.accounts) {
                System.out.println("Pocket number: " + acc.getAccountNumber() + "|| Pocket Name: " + acc.getOwnerName());
            }
            //Choose what account shall be used
            System.out.print("ENTER POCKET NUMBER TO PROCEED: ");
            int enteredAcc = input.nextInt();
            input.nextLine();
            SavingsPocket currentAcc = null;
            
            for (SavingsPocket acc : Main.accounts){ //utilizes a for loop to pass through all existing accounts in the arraylist account and checks and processes each one accordingly
                if (acc.getAccountNumber() == enteredAcc) { //if one iteration of the arraylists of account numbersmatches the entered account, that entered account will now be assigned to the current account, which simply "logs you in" to that iteration of accounts.
                    currentAcc = acc;
                    break;
                };
            }

            // if there are still no accounts in the array list, any input will show this.
            if (currentAcc == null){
                System.out.println("POCKET NOT FOUND!");
            }
            // if there are existing accounts in the array list, it will follow then the for loop thing.
            else {
                boolean matchingPass = false;
                //Validates the password matching with the account's password. Its in a while loop to repeatedly ask for the correct password until the entered password is equal to the stored password.
                while (matchingPass == false){
                        System.out.print("ENTER POCKET KEY TO PROCEED: "); //prompts the user for the password
                        String enteredPass = input.nextLine();
                        if (currentAcc.getPassword().equals(enteredPass)){
                            matchingPass = true; //if the entered password is the same to the stored password, the while loop breaks.
                        }
                        else { //if the password did not match
                            System.out.println("KEY DOESN'T MATCH! TRY AGAIN!");
                        }
                }
                System.out.println("POCKET PEEK SUCCESSFUL FOR POCKET " + currentAcc.getOwnerName().toUpperCase()); //includes the user name to validate the user passed.
                //calls the main menu method
                Main.showMainMenu(currentAcc);
            }
    }
    
    //Method to widthraw funds from an account
    public static void withdrawal(SavingsPocket currentAcc) {
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

