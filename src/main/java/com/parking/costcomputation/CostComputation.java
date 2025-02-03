// com/parking/costcomputation/CostComputation.java
package com.parking.costcomputation;

import com.parking.pricing.PricingStrategy;

public abstract class CostComputation {
    protected PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public abstract int computeCost(long duration);
}