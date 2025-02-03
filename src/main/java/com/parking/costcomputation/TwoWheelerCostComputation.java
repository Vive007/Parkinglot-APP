// com/parking/costcomputation/TwoWheelerCostComputation.java
package com.parking.costcomputation;

import com.parking.pricing.PricingStrategy;

public class TwoWheelerCostComputation extends CostComputation {
    public TwoWheelerCostComputation(PricingStrategy pricingStrategy) {
        super(pricingStrategy);
    }

    @Override
    public int computeCost(long duration) {
        return pricingStrategy.calculatePrice(duration);
    }
}