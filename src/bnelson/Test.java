package bnelson;

import java.util.Scanner;

public class Test {

    private static final Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) {
        System.out.print( "Please enter your password: ");

        String input = scanner.nextLine();

        User user = new User(input);

        System.out.println( "Original password: " + user.getPassword() );
        System.out.println( "Original hash: " + user.getSalt() );
        System.out.println( "Original salt: " + user.getHashedPassword() );

        try {
            NSALoginController.hashUserPassword(user);
        } catch (WeakPasswordException wpe) {


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println( "New password: " + user.getPassword() );
        System.out.println( "New hash: " + user.getSalt() );
        System.out.println( "New salt: " + user.getHashedPassword() );

        System.out.print( "Please enter password again: ");
        input = scanner.nextLine();

        user.setPassword(input);

        try {
            System.out.println( NSALoginController.verifyPassword(user) );
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
