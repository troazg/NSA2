package bnelson;

import java.util.Scanner;

public class Test {

    //Scanner object to capture user input
    private static final Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) {
        System.out.print( "Please enter your password: ");

        // Use scanner to store input into a String
        String input = scanner.nextLine();

        // Call the constructor and pass the password to the new object
        User user = new User(input);

        // Checks to see state of object members
        System.out.println( "Original password: " + user.getPassword() );
        System.out.println( "Original hash: " + user.getSalt() );
        System.out.println( "Original salt: " + user.getHashedPassword() );


        // Loop to handle bad password reattempts
        do {
            try {
                // Run method on our user object
                NSALoginController.hashUserPassword(user);
            } catch (WeakPasswordException wpe) {
                // Try again!
                System.out.println( "Your password is too weak.");
                System.out.println( "Be sure it is at least 8 characters and uses at least 1 digit.");
                System.out.print( "Please enter a different password: ");
                input = scanner.nextLine();
                user.setPassword(input);

            } catch (Exception e) {
                e.printStackTrace();
            }
            // Loop until the hash method is successful
        } while (user.getHashedPassword() == null);


        // Checks to see new state of user object
        System.out.println( "New password: " + user.getPassword() );
        System.out.println( "New hash: " + user.getSalt() );
        System.out.println( "New salt: " + user.getHashedPassword() );

        // Reenter password to verify
        System.out.print( "Please enter password again: ");
        input = scanner.nextLine();

        user.setPassword(input);

        try {
            System.out.println( "Passwords match = " + NSALoginController.verifyPassword(user) );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
