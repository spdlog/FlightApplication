package com.example.flight;

public class Baggage {
    private final long ID;
    private final long TicketID;
    private final boolean IsCheckedIn;

    public Baggage(long id, long ticketID, boolean isCheckedIn) {
        this.ID = id;
        this.TicketID = ticketID;
        this.IsCheckedIn = isCheckedIn;
    }

    public long getTicketID(){
        return TicketID;
    }

    public boolean isCheckedIn(){
        return IsCheckedIn;
    }
}
