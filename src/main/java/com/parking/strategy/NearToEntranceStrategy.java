// com/parking/strategy/NearToEntranceStrategy.java
package com.parking.strategy;

import com.parking.spots.ParkingSpot;
import java.util.List;

public class NearToEntranceStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingList) {
        return parkingList.stream()
                .filter(ParkingSpot::isAvailable)
                .findFirst()
                .orElse(null);
    }
}