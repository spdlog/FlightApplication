package com.example.flight.model;

public class Destination {
    private final long ID;
    private final String Name;
    public Destination(long id, String Name){
        this.ID = id;
        this.Name = Name;
    }

    public long getID() {
        return ID;
    }
}
