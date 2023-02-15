package parkinglot.models;

import java.util.HashMap;

public class MallParkingLot extends ParkingLot implements MallRateStrategy {

    public MallParkingLot() {
        this.floors = new HashMap<>();
    }

    @Override
    public int getBillAmount(SpotType spotType, ParkingTicket ticket) {

        long denominator = 1000 * 60 * 60;
        long duration = (ticket.getExitTime().getTime() - ticket.getEntryTime().getTime()) / denominator;

        if (spotType.equals(SpotType.SMALL)) {
            return (int) (ratePerHourForMotorcycle * duration);
        } else if (spotType.equals(SpotType.MEDIUM)) {
            return (int) (ratePerHourForCar * duration);
        } else {
            return (int) (getRatePerHourForTruck * duration);
        }
    }
}
