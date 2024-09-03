package org.example.component;

import org.example.model.Client;
import org.example.model.Pet;
import org.example.service.ClientService;
import org.example.service.PetService;

public class ApplicationRunner {

    private ClientService clientService = new ClientService();
    private PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
           Client client = clientService.registerNewClient();

           if (client != null) {
               System.out.println("Adding a new pet.");
               Pet pet = petService.registerNewPet();
               client.setPet(pet);
               pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
               System.out.println("Pet has been added.");
           }
        }
    }
}
