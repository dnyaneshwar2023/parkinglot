package parkinglot.models;

import java.util.Date;

public class Receipt {
    public final int ticketID;
    public final int spotNumber;
    public final Date entryTime;
    public final Date exitTime;
    public final int fare;

    public Receipt(int ticketID, int spotNumber, Date entryTime, Date exitTime, int fare) {
        this.ticketID = ticketID;
        this.spotNumber = spotNumber;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
        this.fare = fare;
    }
}
