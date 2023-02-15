package parkinglot.models;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final ArrayList<ParkingSpot> spots;

    public ParkingFloor(int floorNumber, ArrayList<ParkingSpot> spots) {
        this.floorNumber = floorNumber;
        this.spots = spots;
    }

    public void addSpot(ParkingSpot spot){
        spots.add(spot);
    }

    public boolean isSpotAvailable(SpotType spotType) {
        return spots.stream().map(ParkingSpot::getSpotType).anyMatch(type -> type == spotType);
    }

    public Optional<ParkingSpot> getSpot(SpotType type) {
        if(isSpotAvailable(type)) {
            return spots.stream().filter(it -> it.getSpotType() == type && it.isAvailable()).findFirst();
        }
        return Optional.empty();
    }
}
