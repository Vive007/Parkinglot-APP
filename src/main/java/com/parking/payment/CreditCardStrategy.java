// com/parking/payment/CreditCardStrategy.java
package com.parking.payment;

public class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
}