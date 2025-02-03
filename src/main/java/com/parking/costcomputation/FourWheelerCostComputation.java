// com/parking/costcomputation/FourWheelerCostComputation.java
package com.parking.costcomputation;

import com.parking.pricing.PricingStrategy;

public class FourWheelerCostComputation extends CostComputation {
    public FourWheelerCostComputation(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public int computeCost(long duration) {
        return pricingStrategy.calculatePrice(duration) * 2; // Double pricing for four-wheelers
    }
}