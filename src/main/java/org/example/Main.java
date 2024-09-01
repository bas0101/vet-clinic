package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static String PASSWORD = "default";
    static Scanner SCANNER = new Scanner(System.in);
    static String EMAIL_PATERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static String NAME_PATERN = "^[A-Z][a-z]*(?:[ '-][A-Za-z]+)*$";

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

                if (client != null) {
                    System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
                } else {
                    System.out.println("Failed to register new client due to invalid input.");
                }
            } else {
                System.out.println("Provided email is invalid");
            }

    }

    static Client buildClient(String email) {
        Client client = new Client();
        client.email = email;

        // Get and validate first name
        System.out.print("First name: ");
        String firstName = SCANNER.nextLine();
        if (isNameValid(firstName)) {
            client.firstName = firstName;
        } else {
            System.out.println("Provided first name is invalid.");
            return null;  // Stop execution if the first name is invalid
        }

        // Get and validate last name
        System.out.print("Last name: ");
        String lastName = SCANNER.nextLine();
        if (isNameValid(lastName)) {
            client.lastName = lastName;
        } else {
            System.out.println("Provided last name is invalid.");
            return null;  // Stop execution if the last name is invalid
        }

        return client;

    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}