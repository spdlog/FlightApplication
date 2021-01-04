package com.example.flight.model;

public class Flight {
    private final long ID;
    private final String DateTime;
    private final long SourceID;
    private final long DestinationID;

    public Flight(long id, String dateTime, long sourceID, long destinationID) {
        this.ID = id;
        this.DateTime = dateTime;
        this.SourceID = sourceID;
        this.DestinationID = destinationID;
    }

    public long getDestinationID(){
        return DestinationID;
    }
    public long getID() {
        return ID;
    }

    public String getDateTime() {
        return DateTime;
    }

    public long getSourceID() {
        return SourceID;
    }
}
