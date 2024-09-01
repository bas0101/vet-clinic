package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }


    static boolean auth() {
            boolean accepted = false;
            for (int i = 0; i < 3; i++) {
                System.out.print("Password: ");
                String input = SCANNER.nextLine();

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

        static void registerNewClient(){

            System.out.println("Please provide client details.");
            System.out.println("Email: ");

            String email = SCANNER.nextLine();

            if (isEmailValid(email)) {
                Client client = buildClient(email);

                System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
            } else {
                System.out.println("Provided email is invalid");
            }

    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;
        System.out.println("First name: ");
        client.firstName = SCANNER.nextLine();
        System.out.println("Last name: ");
        client.lastName = SCANNER.nextLine();

        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}