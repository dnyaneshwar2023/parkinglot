import parkinglot.factory.ParkingSpotFactory;
import parkinglot.factory.VehicleFactory;
import parkinglot.models.MallParkingLot;
import parkinglot.models.ParkingLot;
import parkinglot.models.SpotType;
import parkinglot.models.VehicleType;

public class Main {
    public static void main(String[] args) throws Exception {

        ParkingLot lot = new MallParkingLot();

        lot.addFloor(1);
        lot.addFloor(2);

        lot.floors.get(1).addSpot(ParkingSpotFactory.getNewSpot(1, SpotType.MEDIUM));
        lot.floors.get(2).addSpot(ParkingSpotFactory.getNewSpot(2, SpotType.SMALL));

        int parkedSpotNumber = lot.parkVehicle(VehicleFactory.getNewVehicle(VehicleType.MOTORCYCLE));

        lot.unparkVehicle(parkedSpotNumber);
    }
}
