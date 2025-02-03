// com/parking/gates/EntranceGate.java
package com.parking.gates;

import com.parking.factory.ParkingSpotFactory;
import com.parking.managers.ParkingSpotManager;
import com.parking.tickets.Ticket;
import com.parking.vehicles.Vehicle;
import com.parking.spots.ParkingSpot;

public class EntranceGate {
    private final ParkingSpotFactory parkingSpotFactory;

    public EntranceGate(ParkingSpotFactory parkingSpotFactory) {
        this.parkingSpotFactory = parkingSpotFactory;
    }

    public ParkingSpot findSpace(Vehicle vehicle) {
        ParkingSpotManager manager = parkingSpotFactory.getParkingSpotManager(vehicle.getVehicleType());
        return manager.findParkingSpace();
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot) {
        return new Ticket(System.currentTimeMillis(), vehicle, parkingSpot);
    }

    public void bookSpot(Vehicle vehicle, ParkingSpot spot) {
        ParkingSpotManager manager = parkingSpotFactory.getParkingSpotManager(vehicle.getVehicleType());
        manager.parkVehicle(vehicle, spot);
    }
}