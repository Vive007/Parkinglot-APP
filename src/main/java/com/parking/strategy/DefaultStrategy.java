// com/parking/strategy/DefaultStrategy.java
package com.parking.strategy;

import com.parking.spots.ParkingSpot;
import java.util.List;
import java.util.Random;

public class DefaultStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingList) {
        return parkingList.stream()
                .filter(ParkingSpot::isAvailable)
                .findAny()
                .orElse(null);
    }
}