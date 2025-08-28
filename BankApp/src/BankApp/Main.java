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
    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static BankAppUI UI = new BankAppUI(); //Ojbect that is utilized to display all of the UI of the project.
    static Scanner input = new Scanner(System.in);
    static Transactions transactions = new Transactions(); //Object that is focused on the transcations of the user.

    public static void main(String[] args) {
        // Declare local variables
        boolean isRunning = true;
        BankAccount currentAcc;

        //Starting menu (Asks user to either choose an existing account, register an account, and exit)
        while (isRunning){
            UI.startingMenu(); // Calls starting menu
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
                case 1 -> Transactions.showRegistrationMenu();
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
                    
                    currentAcc = null;
                    
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
        
        //Main menu method that will be called when the user successfully logs in to their account
    public static void showMainMenu(BankAccount currentAcc) {
        boolean inAccount = true;
        while (inAccount){       
            UI.transactionMenu(); // Calls to the transaction menu
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
                case 2 -> Transactions.deposit(currentAcc);//deposit case
                case 3 -> Transactions.withdrawal(currentAcc);//withdrawal case
                case 4 -> { //exit case
                    System.out.println("TRANSACTION EXITED");
                    inAccount = false;
                }
            }
        }
    currentAcc = null;
    }
}