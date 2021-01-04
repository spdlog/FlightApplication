package com.example.flight;
import com.example.flight.model.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppData {
    private static final Map<Long, Destination> Destinations =  new HashMap <Long, Destination>();
    private static final Map<Long, Flight> Flights =  new HashMap <Long, Flight>();
    private static final Map<Long, Ticket> Tickets =  new HashMap <Long, Ticket>();
    private static final Map<Long, Baggage> Baggages = new HashMap<Long, Baggage>();
    private static final Map<Long, Coupon> Coupons = new HashMap<Long, Coupon>();
    public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public AppData(){
        //  Populating Destinations Data
        Destinations.put((long)99, new Destination(99, "Costa Rica"));
        Destinations.put((long)192, new Destination(192, "Sydney"));
        Destinations.put((long)10, new Destination(10, "Tel Aviv"));

        //  Populating Flights Data
        Flights.put((long) 22, new Flight(22,"19/8/2020 16:00",99,192));
        Flights.put((long) 23, new Flight(23,"01/9/2019 06:00",10,192));

        //  Populating Tickets Data
        Tickets.put((long) 1, new Ticket(1, 22, 100, 5));
        Tickets.put((long) 2, new Ticket(2, 22, 101, 6));
        Tickets.put((long) 3, new Ticket(3, 45, 95, 7));
        Tickets.put((long) 4, new Ticket(4, 107, 13, 8));

        //  Populating Baggages Data
        Baggages.put((long) 11, new Baggage(11, 2, true));
        Baggages.put((long) 87, new Baggage(87, 4, false));
        Baggages.put((long) 52, new Baggage(52, 4, true));

        //  Populating Coupons Data
        Coupons.put((long)1,new Coupon(1));
        Coupons.put((long)2,new Coupon(2));
        Coupons.put((long)3,new Coupon(3));
    }

    public static boolean CheckIfTicketAvailabe(long ticketID){
        return Tickets.containsKey(ticketID);
    }

    public static boolean CheckIfCheckIn(long destinationID, long baggageID){
        try {
            Baggage baggage = Baggages.get(baggageID);
            Ticket ticket = Tickets.get(baggage.getTicketID());
            Flight flight = Flights.get(ticket.getFlightID());
            Destination destination = Destinations.get(flight.getDestinationID());

            return Baggages.containsKey(baggageID) && Baggages.get(baggageID).isCheckedIn() && destination.getID() == destinationID;
        }
        catch (Exception e){
            logger.log(Level.SEVERE, String.format("Exception : %s", e));
            return false;
        }
    }

    public static String CheckCoupon(long couponID, int price){
        if(!Coupons.containsKey(couponID)){
            logger.log(Level.INFO, String.format("Coupon ID = %d does not exist", couponID));
            return String.format("{Price: %d, response:'Coupon does not exist'}",price);
        }
        Coupon coupon = Coupons.get(couponID);
        double dis = (double)price*coupon.getDiscount();
        logger.log(Level.INFO, String.format("Coupon ID = %d Got %.2f Discount ", couponID, dis));
        return String.format("{Price: %.2f, response:'Coupon discount = %.2f '}", dis, coupon.getDiscount());
    }
}
