package com.example.flight.model;

public class Passenger {

    private final long ID;
    private final String FirstName;
    private final String LastName;
    private final String Email;
    private final long Cell;

    public Passenger(long ID, String firstName, String lastName, String email, long cell) {
        this.ID = ID;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.Email = email;
        this.Cell = cell;
    }

    public long getID() {
        return ID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public long getCell() {
        return Cell;
    }
}
