// com/parking/managers/FourWheelerManager.java
package com.parking.managers;

import com.parking.spots.ParkingSpot;
import com.parking.strategy.ParkingStrategy;
import java.util.List;

public class FourWheelerManager extends ParkingSpotManager {
    public FourWheelerManager(List<ParkingSpot> parkingList, ParkingStrategy parkingStrategy) {
        super(parkingList, parkingStrategy);
    }
}