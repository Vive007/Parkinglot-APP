package com.parking.factory;

import com.parking.costcomputation.CostComputation;
import com.parking.costcomputation.FourWheelerCostComputation;
import com.parking.costcomputation.TwoWheelerCostComputation;
import com.parking.enums.VehicleType;
import com.parking.pricing.PricingStrategy;

public class CostComputationFactory {
    public static CostComputation getCostComputation(VehicleType vehicleType, PricingStrategy pricingStrategy) {
        if (vehicleType == VehicleType.BIKE) {
            return new TwoWheelerCostComputation(pricingStrategy);
        } else {
            return new FourWheelerCostComputation(pricingStrategy);
        }
    }
}
