// com/parking/managers/TwoWheelerManager.java
package com.parking.managers;

import com.parking.spots.ParkingSpot;
import com.parking.strategy.ParkingStrategy;
import java.util.List;

public class TwoWheelerManager extends ParkingSpotManager {
    public TwoWheelerManager(List<ParkingSpot> parkingList, ParkingStrategy parkingStrategy) {
        super(parkingList, parkingStrategy);
    }
}