// com/parking/strategy/NearToEndAndElevatorStrategy.java
package com.parking.strategy;

import com.parking.spots.ParkingSpot;
import java.util.List;

public class NearToEndAndElevatorStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingList) {
        return parkingList.stream()
                .filter(ParkingSpot::isAvailable)
                .reduce((first, second) -> second)
                .orElse(null);
    }
}