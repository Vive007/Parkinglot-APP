// com/parking/pricing/MinuteWisePriceStrategy.java
package com.parking.pricing;

public class MinuteWisePriceStrategy implements PricingStrategy {
    @Override
    public int calculatePrice(long duration) {
        long minutes = (duration / (1000 * 60)) + 1;
        return (int) (minutes * 0.5); // $0.5 per minute
    }
}