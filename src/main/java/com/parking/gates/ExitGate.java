// com/parking/gates/ExitGate.java
package com.parking.gates;

import com.parking.tickets.Ticket;
import com.parking.managers.ParkingSpotManager;
import com.parking.pricing.*;
import com.parking.payment.*;
import com.parking.costcomputation.*;

public class ExitGate {
    private final Ticket ticket;
    private final ParkingSpotManager parkingSpotManager;
    private final CostComputation costComputation;

    public ExitGate(Ticket ticket, ParkingSpotManager parkingSpotManager,
                    CostComputation costComputation) {
        this.ticket = ticket;
        this.parkingSpotManager = parkingSpotManager;
        this.costComputation = costComputation;
    }

    public int calculatePrice() {
        long duration = System.currentTimeMillis() - ticket.getEntryTime();
        return costComputation.computeCost(duration);
    }

    public void processPayment(int amount, PaymentStrategy paymentStrategy) {
        paymentStrategy.pay(amount);
        parkingSpotManager.removeVehicle(ticket.getParkingSpot());
    }
}