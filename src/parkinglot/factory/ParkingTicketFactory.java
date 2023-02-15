package parkinglot.factory;

import parkinglot.models.ParkingTicket;

import java.util.Date;
import java.util.HashMap;

public class ParkingTicketFactory {

    public static int ticketID = 0;
    public static HashMap<Integer, ParkingTicket> tickets = new HashMap<>();

    public static void generateTicketFor(int spotID) {
        tickets.remove(spotID);
        ticketID++;
        ParkingTicket ticket = new ParkingTicket(ticketID, spotID, new Date());
        tickets.put(spotID, ticket);
    }
    public static ParkingTicket getTicketFor(int spotID) {
        if (tickets.containsKey(spotID)) {
            return tickets.get(spotID);
        }

        ParkingTicket ticket = new ParkingTicket(ticketID, spotID, new Date());
        tickets.put(spotID, ticket);
        return ticket;
    }

    public static void removeTicketFor(int spotID) {
        tickets.remove(spotID);
    }

}
