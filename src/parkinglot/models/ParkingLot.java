package parkinglot.models;

import parkinglot.factory.ParkingFloorFactory;
import parkinglot.factory.ParkingSpotFactory;
import parkinglot.factory.ParkingTicketFactory;

import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

public abstract class ParkingLot {
    public HashMap<Integer, ParkingFloor> floors;

    public abstract int getBillAmount(SpotType vehicleType, ParkingTicket ticket);

    public void addFloor(int floorNumber) {
        if (!floors.containsKey(floorNumber)) {
            floors.put(floorNumber, ParkingFloorFactory.createParkingFloor(floorNumber));
        }
    }

    public boolean checkAvailability(SpotType spotType) {
        for (ParkingFloor floor : floors.values()) {
            if (floor.isSpotAvailable(spotType)) {
                return true;
            }
        }
        return false;
    }

    public Optional<ParkingSpot> getSpot(SpotType type) {
        if (!checkAvailability(type)) {
            return Optional.empty();
        }
        for (ParkingFloor floor : floors.values()) {
            if (floor.isSpotAvailable(type)) {
                return floor.getSpot(type);
            }
        }
        return Optional.empty();
    }

    public int parkVehicle(Vehicle vehicle) throws Exception {
        Optional<ParkingSpot> availableSpot;
        availableSpot = getAvailableSpot(vehicle);
        if (availableSpot.isEmpty()) {
            throw new Exception("No Spot Available for given vehicle");
        }

        ParkingSpot spot = availableSpot.get();

        spot.setVehicle(vehicle);

        ParkingTicketFactory.generateTicketFor(spot.getSpotID());

        return spot.getSpotID();
    }

    public Receipt unparkVehicle(int spotNumber) {
        ParkingSpot spot = ParkingSpotFactory.getParkingSpot(spotNumber);
        ParkingTicket ticket = ParkingTicketFactory.getTicketFor(spotNumber);

        Date exitTime = new Date();
        exitTime.setHours(exitTime.getHours() + 1);

        spot.removeVehicle();

        int fare = this.getBillAmount(spot.getSpotType(), ticket);

        return new Receipt(ticket.getTicketID(), ticket.getSpotNumber(), ticket.getEntryTime(), exitTime, fare);
    }

    private Optional<ParkingSpot> getAvailableSpot(Vehicle vehicle) {
        if (vehicle.getVehicleType() == VehicleType.CAR) {
            return getSpot(SpotType.MEDIUM);
        } else if (vehicle.getVehicleType() == VehicleType.MOTORCYCLE) {
            return getSpot(SpotType.SMALL);
        } else {
            return getSpot(SpotType.LARGE);
        }

    }

}
