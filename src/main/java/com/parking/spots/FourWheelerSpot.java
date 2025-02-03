// com/parking/spots/FourWheelerSpot.java
package com.parking.spots;

import com.parking.enums.SpotType;

public class FourWheelerSpot extends ParkingSpot {
    public FourWheelerSpot(int parkingSpotId, int parkingPrice) {
        super(parkingSpotId, parkingPrice, SpotType.FOUR_WHEELER);
    }

    public int price() { return getParkingPrice(); }
}