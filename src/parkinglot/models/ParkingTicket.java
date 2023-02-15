package parkinglot.models;

import java.util.Date;

public class ParkingTicket {
    private final int ticketID;
    private final int spotNumber;
    private final Date entryTime;

    public ParkingTicket(int ticketID, int spotNumber, Date entryTime) {
        this.ticketID = ticketID;
        this.spotNumber = spotNumber;
        this.entryTime = entryTime;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public int getTicketID() {
        return ticketID;
    }
}
