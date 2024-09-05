package org.example;

import org.example.comporator.DogSizeComparator;
import org.example.model.Dog;

import java.util.Arrays;

public class Sandbox {
    public static void main(String[] args) {
        Dog[] dogs = {
                new Dog(Dog.M),
                new Dog(Dog.L),
                new Dog(Dog.S),
                new Dog(Dog.XL),
                new Dog(Dog.S),
                new Dog(Dog.M)
        };

        Arrays.sort(dogs, new DogSizeComparator());

        for (Dog dog : dogs) {
            System.out.println(dog.getSize());
        }
    }
}
