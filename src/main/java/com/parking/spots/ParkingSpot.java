// com/parking/spots/ParkingSpot.java
package com.parking.spots;

import com.parking.enums.SpotType;
import com.parking.vehicles.Vehicle;

public abstract class ParkingSpot {
    private final int parkingSpotId;
    private final int parkingPrice;
    private final SpotType spotType;
    private boolean isAvailable;
    private Vehicle vehicle;

    public ParkingSpot(int parkingSpotId, int parkingPrice, SpotType spotType) {
        this.parkingSpotId = parkingSpotId;
        this.parkingPrice = parkingPrice;
        this.spotType = spotType;
        this.isAvailable = true;
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isAvailable = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isAvailable = true;
    }

    // Getters
    public int getParkingSpotId() { return parkingSpotId; }
    public boolean isAvailable() { return isAvailable; }
    public int getParkingPrice() { return parkingPrice; }
    public SpotType getSpotType() { return spotType; }
}