// com/parking/strategy/ParkingStrategy.java
package com.parking.strategy;

import com.parking.spots.ParkingSpot;
import java.util.List;

public interface ParkingStrategy {
    ParkingSpot findSpot(List<ParkingSpot> parkingList);
}