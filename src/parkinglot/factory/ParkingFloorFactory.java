package parkinglot.factory;

import parkinglot.models.ParkingFloor;
import parkinglot.models.ParkingSpot;

import java.util.ArrayList;

public class ParkingFloorFactory {
    public static ParkingFloor createParkingFloor(int floorNumber) {
        return new ParkingFloor(floorNumber, new ArrayList<ParkingSpot>());
    }
}
