package org.example.model;

import java.util.Objects;

public class Dog extends Pet{

    private Size size;

    public Dog(){};

    public Dog(Size size) {
        this.size = size;
    }



    public Dog(Size size, String age) {
        this.size = size;
        setAge(age); // Виклик методу setAge() для встановлення віку
    }



    @Override
    public String toString() {
        return "Dog {"
                + "type = " + getType()
                + ", sex = " + getSex()
                + ", age = " + getAge()
                + ", name = " + getName()
                + ", size = " + getSize()
                +", ownerName='" + getOwnerName() + '\'' +
                ", registrationDate='" + getRegistrationDate().format(FORMATTER) + '\''

                + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(size, dog.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size);
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public enum Size {
        XS(1),
        S(2),
        M(3),
        L(4),
        XL(5),
        UNKNOWN(0);


        private final int value;


        Size(int value) {
            this.value = value;
        }

        public static Size fromString(String value) {
            for (Size size: values()) {
                if (size.toString().equals(value)) {
                    return size;
                }
            }

            System.out.println("Unable to parse value '" + value
                    + "', Using default value: " + UNKNOWN);
            return UNKNOWN;
        }
        public int getValue() {
            return value;
        }
    }
}
