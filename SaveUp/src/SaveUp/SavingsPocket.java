package SaveUp;

public class SavingsPocket {
    private static int nextAccountNumber = 1; //starting point of the account number generator.
    private int accountNumber; 
    private String ownerName;
    private double balance;
    private String password;

    public SavingsPocket(String ownerName, String password) {
        this.ownerName = ownerName;
        this.accountNumber = nextAccountNumber++; //assigns the int nextAccountNumber to the savings pocket user. And after assigning it, It increments to prepare for the next pocket to be added.
        this.balance = 0.0;
        this.password = password;
    }

    public int getAccountNumber() { //getter for the account number
        return this.accountNumber;
    }

    public String getOwnerName() { //getter for the owner's name
        return this.ownerName;
    }

    public double showBalance() { //getter for the balance
        return this.balance;
    }

    public String getPassword() { //getter for the password
        return this.password;
    }

    //Main deposit method that actually adds funds to the account, instead of the deposit metehod in transactions class which validates the deposit
    public void deposit(double amount){
            this.balance += amount;
            System.out.println("DEPOSIT SUCCESS");
            System.out.printf("DEPOSIT AMOUNT: $%.2f\n", amount);
            System.out.printf("AVAILABLE BALANCE: $%.2f\n", this.balance);
    }
    //Main withdrawal method that actually adds funds to the account, instead of the withdraw metehod in transactions class which validates user's input before proceeding to this method.
    public void withdraw(double amount){
            this.balance -= amount;
            System.out.println("WITHDRAWAL SUCCESS");
            System.out.printf("WITHDRAWAL AMOUNT: $%.2f\n", amount);
            System.out.printf("AVAILABLE BALANCE: $%.2f\n", this.balance);
    }
}   
