// com/parking/tickets/Ticket.java
package com.parking.tickets;

import com.parking.spots.ParkingSpot;
import com.parking.vehicles.Vehicle;

public class Ticket {
    private final long entryTime;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;

    public Ticket(long entryTime, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    public long getEntryTime() { return entryTime; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSpot getParkingSpot() { return parkingSpot; }
}