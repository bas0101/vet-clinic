package org.example;

import org.example.comporator.DogSizeComparator;
import org.example.comporator.PetAgeComparator;
import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Pet;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M, "2"),
                new Dog(Dog.L, "8"),
                new Dog(Dog.S, "1"),
                new Dog(Dog.XL, "9"),
                new Dog(Dog.S, "4"),
                new Dog(Dog.M, "3")
        };

        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Arrays.sort(dogs, new PetAgeComparator());
        System.out.println("\nСортування за віком:");
        for (Dog dog : dogs) {
            System.out.println(dog.getSize() + " (age=" + dog.getAge() + ")");
        }
    }
}
