package org.example.component;

import org.example.Main;
import org.example.model.Client;
import org.example.model.Pet;
import org.example.service.ClientService;
import org.example.service.PetService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EntityRegister {
    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();
    public void registerClients(){
        List<Client> clients = new ArrayList<>();

        String message = "Do you want to register more clients? (y/n):  ";

        do {
            Client client = addClient();
            if (client != null){
                clients.add(client);
            }

        } while (verifyRepeating(message));

        Map<Client.Location, List<Client>> clientsByLocation = groupClients(clients);
        printClients(clientsByLocation);

    }

    private void printClients(Map<Client.Location, List<Client>> clientsByLocation) {
        for (Map.Entry<Client.Location, List<Client>> clients : clientsByLocation.entrySet()) {
            String content = "\nLocation: " +   clients.getKey()
                    + "\nClients (" + clients.getValue().size() + "):"
                    + "\n\t" + clients.getValue();
            System.out.println(content);
        }
    }

    private Map<Client.Location,List<Client>> groupClients(List<Client> clients) {
        List<Client> fromKyiv = new ArrayList<>();
        List<Client> fromLviv = new ArrayList<>();
        List<Client> fromOdesa = new ArrayList<>();
        List<Client> fromSumy = new ArrayList<>();
        List<Client> unknownLocation = new ArrayList<>();

        for (Client client : clients) {
            switch (client.getLocation()) {
                case KYIV -> fromKyiv.add(client);
                case LVIV -> fromLviv.add(client);
                case ODESA -> fromOdesa.add(client);
                case SUMY -> fromSumy.add(client);
                case UNKNOWN -> unknownLocation.add(client);
            }
        }

        Map<Client.Location, List<Client>> clientsByLocation = new HashMap<>();
        clientsByLocation.put(Client.Location.KYIV, fromKyiv);
        clientsByLocation.put(Client.Location.ODESA, fromOdesa);
        clientsByLocation.put(Client.Location.LVIV, fromLviv);
        clientsByLocation.put(Client.Location.SUMY, fromSumy);
        clientsByLocation.put(Client.Location.UNKNOWN, unknownLocation);

        return clientsByLocation;

    }

    private Client addClient(){
        Client client = clientService.registerNewClient();

        if (client != null) {
            System.out.println("Would you like to register a pet? (yes/no): ");
            String response = Main.SCANNER.nextLine();

            if ("yes".equals(response)) {
                registerPets(client);
            } else {
                System.out.println("Client registration completed without a pet.");
            }
        }
        return client;
    }

    private void registerPets(Client client){
        String message = "Do you want to add more pets to the current client? (y/n): ";
        do {
            addPet(client);
        } while (verifyRepeating(message));
    }

    private void addPet (Client client){



        System.out.println("Adding a new pet.");
        Pet pet = petService.registerNewPet();
        if (pet != null) {
            client.addPet(pet);
            pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
            System.out.println("Pet has been added.");
        }
        System.out.println(client);
    }

    private boolean verifyRepeating(String message) {
        System.out.println(message);

        String answer = Main.SCANNER.nextLine();
        if ("y".equals(answer)){
            return true;
        } else if ("n".equals(answer)) {
            return false;
        } else {
            System.out.println("Incorect answer. Please try again.");
            return verifyRepeating(message);
        }
    }
}
