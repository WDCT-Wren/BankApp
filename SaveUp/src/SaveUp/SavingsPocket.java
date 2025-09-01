package SaveUp;

public class SavingsPocket {
    private static int nextAccountNumber = 1; //starting point of the account number generator.
    private int accountNumber; 
    private String ownerName;
    private double balance;

    public SavingsPocket(String ownerName) {
        this.ownerName = ownerName;
        this.accountNumber = nextAccountNumber++; //assigns the current account number and then increments for the next account
        this.balance = 0.0;
    }

    public int getAccountNumber() { //getter for the account number
        return this.accountNumber;
    }

    public String getOwnerName() { //getter for the owner's name
        return this.ownerName;
    }

    //if user wants to see their balance:
    public double showBalance() { //getter for the balance
        return this.balance;
    }

    //Deposit method
    public void deposit(double amount){
            this.balance += amount;
            System.out.println("DEPOSIT SUCCESS");
            System.out.printf("DEPOSIT AMOUNT: $%.2f\n", amount);
            System.out.printf("AVAILABLE BALANCE: $%.2f\n", this.balance);
    }
    //Withdrawal method
    public void withdraw(double amount){
            this.balance -= amount;
            System.out.println("WITHDRAWAL SUCCESS");
            System.out.printf("WITHDRAWAL AMOUNT: $%.2f\n", amount);
            System.out.printf("AVAILABLE BALANCE: $%.2f\n", this.balance);
    }
}   
