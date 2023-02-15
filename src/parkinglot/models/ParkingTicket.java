package parkinglot.models;

import java.util.Date;

public class ParkingTicket {
    private final int ticketID;
    private final int spotNumber;
    private final Date entryTime;
    private Date exitTime;
    private int fare;

    public ParkingTicket(int ticketID, int spotNumber, Date entryTime) {
        this.ticketID = ticketID;
        this.spotNumber = spotNumber;
        this.entryTime = entryTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getTicketID() {
        return ticketID;
    }
}
