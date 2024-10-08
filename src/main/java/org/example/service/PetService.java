package org.example.service;

import org.example.Main;
import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Pet;

public class PetService {

    private static final String DOG_TYPE = "dog";
    private static final String CAT_TYPE = "cat";

    public Pet registerNewPet() {
        Pet pet = null;

        System.out.print("Type (dog / cat): ");
        String type = Main.SCANNER.nextLine();


        if (DOG_TYPE.equals(type) || CAT_TYPE.equals(type)) {
            pet = buildPet(type);
        } else {
            System.out.println("Unknown pet type: " + type);;
        }
        return pet;
    }


    private Pet buildPet (String type) {
        Pet pet = type.equals(CAT_TYPE) ? new Cat() : new Dog();
        pet.setType(type);

        System.out.print("Age: ");
        pet.setAge(Main.SCANNER.nextLine());

        System.out.print("Name: ");
        pet.setName(Main.SCANNER.nextLine());;

        System.out.print("Sex (male/female): ");
        pet.setSex(Main.SCANNER.nextLine());

        if (type.equals(DOG_TYPE)) {
            System.out.println("Size (XS / S / M / L / XL): ");
            String size = Main.SCANNER.nextLine();
            ((Dog) pet).setSize(Dog.Size.fromString(size));
        }

        return pet;
    }
}
