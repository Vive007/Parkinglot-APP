// com/parking/factory/ParkingSpotFactory.java
package com.parking.factory;

import com.parking.enums.VehicleType;
import com.parking.managers.*;
import com.parking.spots.*;
import com.parking.strategy.*;
import java.util.*;

public class ParkingSpotFactory {
    public ParkingSpotManager getParkingSpotManager(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return new TwoWheelerManager(
                        new ArrayList<>(Arrays.asList(
                                new TwoWheelerSpot(1, 20),
                                new TwoWheelerSpot(2, 20)
                        )),
                        new NearToEntranceStrategy()
                );
            case CAR:
                return new FourWheelerManager(
                        new ArrayList<>(Arrays.asList(
                                new FourWheelerSpot(3, 50),
                                new FourWheelerSpot(4, 50)
                        )),
                        new NearToEntranceStrategy()
                );
            default:
                throw new IllegalArgumentException("Unsupported vehicle type");
        }
    }
}