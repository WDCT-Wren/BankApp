/* Day 5-Day 7  (Simple OOP project) (08/24/25 - 08/26/25)
 * Simple Bank teller program that utilizes java's OOP features.
 * Kind of hard and made me use chatgpt more than anticipated although I learned a lot in OOP principles at the same time
 * Will update tomorrow with log in features utilizing arrays and arraylists.
 */

package BankApp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Declared global variables
    static Scanner input = new Scanner(System.in);
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    public static void main(String[] args) {
        // Declare local variables
        boolean isRunning = true;

        //Starting menu (Asks user to either choose an existing account, register an account, and exit)
        while (isRunning){
            // starting menu screen
            System.out.println("********************************************");
            System.out.println("BANK OF THE BOURGEOISIES OF CALIFORNIA (BBC)");
            System.out.println("********************************************");
            System.out.println("1. Register New Account");
            System.out.println("2. Choose Existing Account");
            System.out.println("3. exit");
            System.out.println("********************************************");
            
            boolean validChoice = false;
            int choice = 0;

            //input validation for the starting menu
            while (validChoice == false) {
                try { 
                    System.out.print("Please Choose an action to proceed: ");
                    choice = input.nextInt();
                    input.nextLine();
                    if (choice < 1 || choice > 3) { //exception handling if the user input is not between 1 or 3
                        System.out.println("INVALID CHOICE! Please enter a number between 1-3.");
                    }
                    else {
                        validChoice = true;
                    }
                }
                catch(java.util.InputMismatchException e) { //exception handling if the user input is not the same type to the choice (int)
                    System.out.println("INVALID INPUT! Please enter a number between 1-3.");
                    input.nextLine(); // clear the invalid input
                }
            }

            switch (choice) {
                case 1 -> {
                    showRegistrationMenu();
                }
                case 2 -> {
                    // Show available accounts in the session
                    System.out.println("AVAILABLE ACCOUNTS: ");
                    for (BankAccount acc : accounts) {
                        System.out.println("Account number: " + acc.getAccountNumber() + "|| Owner: " + acc.getOwnerName());
                    }

                    //Choose what account shall be used
                    System.out.print("ENTER ACCOUNT NUMBER TO PROCEED: ");
                    int enteredAcc = input.nextInt();
                    input.nextLine();

                    BankAccount currentAcc = null;
                    
                    for (BankAccount acc : accounts){ //utilizes a for loop to pass through all existing accounts in the arraylist account and checks and processes each one accordingly
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
                        showMainMenu(currentAcc);
                    }
                }
                case 3 -> { //if user chooses to exit the session
                    System.out.println("MENU EXITED");
                    System.out.println("SESSION ENDED");
                    System.out.println("THANK YOU FOR BANKING WITH US!");
                    isRunning = false;
                }
            }
        }
        input.close();
    } 

    //Registration menu method that will be called when the user wants to register a new account
    public static void showRegistrationMenu() {
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

            accounts.add(newAccount); //adds the account to the BankAccount Arraylists inside the Main itself
            
            System.out.println("ACCOUNT REGISTERD SUCCESSFULLY");
            System.out.println("YOUR REGISTERED ACCOUNT NUMBER: " + newAccountNumber);
            
    }
        
        //Main menu method that will be called when the user successfully logs in to their account
    public static void showMainMenu(BankAccount currentAcc) {
        boolean inAccount = true;
        while (inAccount){       
            // Menu Screen
            System.out.println("***************");
            System.out.println("1. Show Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("***************");

            boolean validChoice = false;
            int accountChoice = 0;
            
                // Validate input in transaction menu
                while (validChoice == false){
                    try {
                        System.out.print("Enter your transaction (1-4): "); // Get and process user choice
                        accountChoice = input.nextInt();
                        if (accountChoice < 1 || accountChoice > 4){
                            System.out.println("INVALID CHOICE! Please choose between 1-4.");
                        }
                        else {
                            validChoice = true;
                        }
                    }
                    catch (java.util.InputMismatchException e){ 
                        System.out.println("INVALID CHOICE! please choose between 1-4.");
                        input.nextLine();
                    }
                }
                switch (accountChoice) {
                    case 1 -> System.out.printf("YOUR BALANCE: $%.2f\n", currentAcc.showBalance()); //show balance case
                    case 2 -> deposit(currentAcc);//deposit case
                    case 3 -> withdrawal(currentAcc);//withdrawal case
                    case 4 -> { //exit case
                        System.out.println("TRANSACTION EXITED");
                        inAccount = false;
                    }
                }
            }
        currentAcc = null;
    }

    //depositing validation method
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

    //withdrawal validation method
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