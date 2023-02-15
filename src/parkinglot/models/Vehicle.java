package parkinglot.models;

public class Vehicle {
    private final int vehicleNumber;
    private final VehicleType vehicleType;

    public Vehicle(int vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
