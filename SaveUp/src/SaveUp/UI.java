/* UI
 * This class is self explanatory, which is to show the program's User interface
 * 
 * This class specifically has 3 UI methods:
 * - The end menu
 * - The starting menu
 * - The transaction menu
 */

package SaveUp;

public class UI {
        public void endMenu() {
                System.out.println("MENU EXITED");
                System.out.println("SESSION ENDED");
                Main.isRunning = false;
        }

        public void startingMenu() {
                System.out.println("**************************");
                System.out.println("       SAVEUP POCKET      ");
                System.out.println("**************************");
                System.out.println("1. Add A New Pocket");
                System.out.println("2. Choose Existing Pocket");
                System.out.println("3. exit");
                System.out.println("**************************");
        }

        public void transactionMenu(SavingsPocket currentAcc) {
                System.out.println("**************************");
                System.out.println("Current Balance: " + currentAcc.getBalance());
                System.out.println("**************************");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Exit");
                System.out.println("**************************");
        }
}