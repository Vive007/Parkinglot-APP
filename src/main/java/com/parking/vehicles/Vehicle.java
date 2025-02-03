// com/parking/vehicles/Vehicle.java
package com.parking.vehicles;

import com.parking.enums.VehicleType;

public class Vehicle {
    private final int vehicleNo;
    private final VehicleType vehicleType;

    public Vehicle(int vehicleNo, VehicleType vehicleType) {
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public int getVehicleNo() { return vehicleNo; }
    public VehicleType getVehicleType() { return vehicleType; }
}