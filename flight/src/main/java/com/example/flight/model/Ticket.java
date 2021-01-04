package com.example.flight.model;
import java.util.logging.Logger;

public class Ticket {

    private final long ID;
    private final long FlightID;
    private final double Price;
    private final long PassengerID;

    public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public Ticket(long id, long flightID, double price, long passengerID) {
        this.ID = id;
        this.FlightID = flightID;
        this.Price = price;
        this.PassengerID = passengerID;
    }

    public long getFlightID(){
        return FlightID;
    }

    public long getID() {
        return ID;
    }

    public double getPrice() {
        return Price;
    }

    public long getPassengerID() {
        return PassengerID;
    }
}


