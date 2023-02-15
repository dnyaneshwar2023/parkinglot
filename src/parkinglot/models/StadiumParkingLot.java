package parkinglot.models;

public class StadiumParkingLot extends ParkingLot {
    @Override
    public int getBillAmount(SpotType vehicleType, ParkingTicket ticket) {
        return 0;
    }
}
