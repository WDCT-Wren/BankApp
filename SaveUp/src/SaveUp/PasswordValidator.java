package SaveUp;

/*
 * This is a class for the purposes of validating the password the user will input
 * 
 * This class currently have 2 methods, strongPassword and matchingPass
 * 
 * strongPassword has the primary function of checking if the inputted password meets the following criterias:
 * - Longer than 8 characters
 * - Has a capital letter
 * - Has a numeric character
 * - Has a spcecial character
 * 
 * matchingPass meanwhile, validates if the password when confirmed, matches with the first password input.
 */

public class PasswordValidator {
    //Methods that check the strength of the password
    public static boolean strongPassword(String password) {
        while (true) {
            //initates boolean variables that the program will be checking
            boolean hasNumber = password.matches(".*[0-9].*"); //Regex check if password contains a number
            boolean hasCapital = password.matches(".*[A-Z].*"); //Regex check if password contains a capital letter
            boolean hasSpecialChar = password.matches(".*[!@#$%^&*:;',.].*"); //Regex check if password contains a special character

            // In the case that the password does not contain at least 8 characters
            if (password.length() < 8) {
                System.out.println("INVALID KEY! PASSWORD MUST BE AT LEAST 8 CHARACTERS LONG");
            } 
            
            // In the case that the password does not contain a numeric character
            else if (!hasNumber) {
                System.out.println("INVALID KEY! PASSWORD MUST CONTAIN A NUMERIC CHARACTER");
            } 
            
            // In the case that the password does not contain an uppercase letter
            else if (!hasCapital) {
                System.out.println("INVALID KEY! PASSWORD MUST CONTAIN AN UPPERCASE CHARACTER");
            } 
            
            // In the case that the password does not contain a special character
            else if (!hasSpecialChar) {
                System.out.println("INVALID KEY! PASSWORD MUST CONTAIN AT LEAST ONE SPECIAL CHARACTER");
            } 
            
            else {
                // All conditions met
                return true;
            }
            System.out.print("ENTER A NEW POCKET KEY: ");
            password = Transactions.input.nextLine();
        }
    }

    //Method that checks if the password and the confirmed input matches
    public static boolean matchingPass(String password, String password2) { 
        while (true) {
            boolean matchingPass = password.equals(password2);

            // If the passwords does not match
            if (!matchingPass) {
                System.out.println("PASSWORD DOES NOT MATCH!");
            } 
            
            else {
                return true;
            }
            System.out.print("CONFIRM POCKET KEY: ");
            password2 = Transactions.input.nextLine();
        }
    }
}
