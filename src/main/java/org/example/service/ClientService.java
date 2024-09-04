package org.example.service;

import org.example.Main;
import org.example.model.Client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientService {

    private static final String EMAIL_PATERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String NAME_PATERN = "^[A-Z][a-z]*(?:[ '-][A-Za-z]+)*$";

   public Client registerNewClient(){
       Client client = null;

        System.out.println("Please provide client details.");
        System.out.print("Email: ");

        String email = Main.SCANNER.nextLine();

        if (isEmailValid(email)) {
            client = buildClient(email);

            if (client != null) {
                System.out.println("New client: " + client.getFirstName() + " "
                        + client.getLastName() + " ("
                        + client.getEmail() + ")");
            } else {
                System.out.println("Failed to register new client due to invalid input.");
            }
        } else {
            System.out.println("Provided email is invalid");
        }
        return client;

    }

    private static Client buildClient(String email) {
        Client client = new Client();
        client.setEmail(email);

        // Get and validate first name
        System.out.print("First name: ");
        String firstName = Main.SCANNER.nextLine();
        if (isNameValid(firstName)) {
            client.setFirstName(firstName);
        } else {
            System.out.println("Provided first name is invalid.");
            return null;  // Stop execution if the first name is invalid
        }

        // Get and validate last name
        System.out.print("Last name: ");
        String lastName = Main.SCANNER.nextLine();
        if (isNameValid(lastName)) {
            client.setLastName(lastName);
        } else {
            System.out.println("Provided last name is invalid.");
            return null;  // Stop execution if the last name is invalid
        }

        return client;

    }

    private static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean isNameValid(String name) {
        Pattern pattern = Pattern.compile(NAME_PATERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
