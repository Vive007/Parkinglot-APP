// com/parking/payment/UPIStrategy.java
package com.parking.payment;

public class UPIStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via UPI");
    }
}