// com/parking/spots/TwoWheelerSpot.java
package com.parking.spots;

import com.parking.enums.SpotType;

public class TwoWheelerSpot extends ParkingSpot {
    public TwoWheelerSpot(int parkingSpotId, int parkingPrice) {
        super(parkingSpotId, parkingPrice, SpotType.TWO_WHEELER);
    }

    public int price() { return getParkingPrice(); }
}