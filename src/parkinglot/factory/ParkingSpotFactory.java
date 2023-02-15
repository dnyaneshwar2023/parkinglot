package parkinglot.factory;


import parkinglot.models.ParkingSpot;
import parkinglot.models.SpotType;

import java.util.HashMap;

public class ParkingSpotFactory {
    public static int spotID = 0;

    public static HashMap<Integer, ParkingSpot> spots = new HashMap<>();


    public static ParkingSpot getNewSpot(int floorNumber, SpotType spotType) {
        spotID++;
        ParkingSpot newSpot = new ParkingSpot(spotID, floorNumber, spotType);
        spots.put(spotID, newSpot);
        return newSpot;
    }

    public static ParkingSpot getParkingSpot(int spotNumber) {
        return spots.get(spotNumber);
    }
}
