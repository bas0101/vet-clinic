package org.example.component;

import org.example.Main;

public class Authenticator {
    private static String PASSWORD = "1";
   public static boolean auth() {
        boolean accepted = false;
        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = Main.SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Pleas check your password.");
            }
        }
        System.out.println(accepted ? "Welcome to the Vet clinic" : "Application has bin blocked.");
        return accepted;
    }
}
