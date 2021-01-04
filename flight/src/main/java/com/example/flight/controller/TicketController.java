package com.example.flight.controller;

import com.example.flight.AppData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class TicketController {
    public final static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @GetMapping("/checkIfTicketAvailable")
    public boolean checkTicket(@RequestParam(value = "ID",defaultValue = "0") long ticketID) {
        logger.log(Level.INFO, String.format("GET Request: CheckTicket for ID = %d",ticketID));
        boolean res = AppData.CheckIfTicketAvailabe(ticketID);
        if(res) {
            logger.log(Level.INFO, String.format("ID = %d is available", ticketID));
            return true;
        }
        logger.log(Level.INFO, String.format("ID = %d is not available",ticketID));
        return false;
    }

    @GetMapping("/checkIfCheckedIn")
    public boolean checkCheckIn(@RequestParam(value = "DestinationID",defaultValue = "0") long DestinationID,
                                @RequestParam(value = "BaggageID",defaultValue = "0") long BaggageID) {
        logger.log(Level.INFO, String.format("GET Request: CheckCheckIn for DestinationID = %d and BaggageID = %d", DestinationID, BaggageID));
        boolean checkin = AppData.CheckIfCheckIn(DestinationID, BaggageID);
        if(checkin) {
            logger.log(Level.INFO, String.format("CheckIn Passed for DestinationID = %d and BaggageID = %d", DestinationID, BaggageID));
            return checkin;
        }
        logger.log(Level.INFO, String.format("CheckIn Failed for DestinationID = %d and BaggageID = %d", DestinationID, BaggageID));
        return checkin;
    }

    @GetMapping("/CheckCoupon")
    public String CheckCoupon(@RequestParam(value = "CouponID",defaultValue = "0") long CouponID,
                                @RequestParam(value = "Price",defaultValue = "0")int Price) {
        logger.log(Level.INFO, String.format("GET Request: CheckCoupon for CouponID = %d and Price = %d", CouponID, Price));
        String res = AppData.CheckCoupon(CouponID, Price);
        logger.log(Level.INFO, String.format("After Checking Coupon : %s", res));
        return res;
    }
}