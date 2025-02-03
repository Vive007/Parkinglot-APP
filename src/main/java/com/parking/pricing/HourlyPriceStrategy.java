// com/parking/pricing/HourlyPriceStrategy.java
package com.parking.pricing;

public class HourlyPriceStrategy implements PricingStrategy {
    @Override
    public int calculatePrice(long duration) {
        long hours = (duration / (1000 * 60 * 60)) + 1;
        return (int) (hours * 20); // $20 per hour
    }
}