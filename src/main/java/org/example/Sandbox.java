package org.example;


import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Pet;

import java.util.Arrays;
import java.util.Comparator;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.Size.M, "2"),
                new Dog(Dog.Size.L, "8"),
                new Dog(Dog.Size.S, "1"),
                new Dog(Dog.Size.XL, "9"),
                new Dog(Dog.Size.S, "4"),
                new Dog(Dog.Size.M, "3")
        };

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return o1.getSize().getValue() - o2.getSize().getValue();
            }
        });

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }

        Arrays.sort(dogs, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                return Integer.compare(Integer.parseInt(o1.getAge()), Integer.parseInt(o2.getAge()));
            }
        });

        System.out.println("\nСортування за віком:");
        for (Dog dog : dogs) {
            System.out.println(dog.getSize() + " (age=" + dog.getAge() + ")");
        }
    }
}
