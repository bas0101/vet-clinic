package org.example.component;

import org.example.Main;
import org.example.model.Client;
import org.example.model.Pet;
import org.example.service.ClientService;
import org.example.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        Client client;
        if (Authenticator.auth()) {
            client = clientService.registerNewClient();

            if (client != null) {
                System.out.println("Would you like to register a pet? (yes/no): ");
                String response = Main.SCANNER.nextLine();

                if ("yes".equals(response)) {
                    registerPets(client);
                } else {
                        System.out.println("Client registration completed without a pet.");
                    }
            }
        }
    }

    private void registerPets(Client client){
        boolean continueAddPets = true;

        while (continueAddPets) {
            addPet(client);
            System.out.print("Do you want to add more pets to the current client? (y/n): ");
            String answer = Main.SCANNER.nextLine();

            if("n".equals(answer)){
                continueAddPets = false;
            }
        }
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
        }


