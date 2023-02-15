package parkinglot.models;

public class ParkingSpot {
    private final int spotID;
    private final int floor;

    private ParkingStatus status;
    private final SpotType spotType;
    private Vehicle vehicle;

    public ParkingSpot(int spotID, int floor, SpotType spotType) {
        this.spotID = spotID;
        this.floor = floor;
        this.spotType = spotType;
        this.status = ParkingStatus.UNPARKED;
    }

    public int getSpotID() {
        return spotID;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.status = ParkingStatus.PARKED;
    }

    public void removeVehicle() {
        vehicle = null;
        status = ParkingStatus.UNPARKED;
    }

    public boolean isAvailable() {
        return this.status == ParkingStatus.UNPARKED;
    }


}
