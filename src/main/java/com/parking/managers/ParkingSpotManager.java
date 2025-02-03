// com/parking/managers/ParkingSpotManager.java
package com.parking.managers;

import com.parking.spots.ParkingSpot;
import com.parking.vehicles.Vehicle;
import com.parking.strategy.ParkingStrategy;
import java.util.List;

public abstract class ParkingSpotManager {
    protected List<ParkingSpot> parkingList;
    protected ParkingStrategy parkingStrategy;

    public ParkingSpotManager(List<ParkingSpot> parkingList, ParkingStrategy parkingStrategy) {
        this.parkingList = parkingList;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot findParkingSpace() {
        return parkingStrategy.findSpot(parkingList);
    }

    public void addParkingSpace(ParkingSpot spot) {
        parkingList.add(spot);
    }

    public void removeParkingSpace(ParkingSpot spot) {
        parkingList.remove(spot);
    }

    public void parkVehicle(Vehicle vehicle, ParkingSpot spot) {
        spot.parkVehicle(vehicle);
    }

    public void removeVehicle(ParkingSpot spot) {
        spot.removeVehicle();
    }
}