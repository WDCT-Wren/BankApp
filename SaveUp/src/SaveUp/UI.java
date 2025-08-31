package SaveUp;

public class UI {
        public void endMenu() {
                System.out.println("MENU EXITED");
                System.out.println("SESSION ENDED");
                System.out.println("THANK YOU FOR BANKING WITH US!");
                Main.isRunning = false;
        }

        public void startingMenu() {
                System.out.println("**************************");
                System.out.println("          SAVEUP          ");
                System.out.println("**************************");
                System.out.println("1. Register New Account");
                System.out.println("2. Choose Existing Account");
                System.out.println("3. exit");
                System.out.println("**************************");
        }

        public void transactionMenu() {
                System.out.println("***************");
                System.out.println("1. Show Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.println("***************");
        }
}