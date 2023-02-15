package parkinglot.factory;

import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;

public class VehicleFactory {

    public static int vehicleNumber = 0;
    public static Vehicle getNewVehicle(VehicleType vehicleType){
        return new Vehicle(vehicleNumber, vehicleType);
    }
}
