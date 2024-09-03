package org.example.model;

public class Client {
    private String firstName;
    private String lastName;
    private String email;
    private Pet pet;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Pet getPet() {
        return pet;
    }
}
