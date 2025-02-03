package com.parking;

import com.parking.costcomputation.CostComputation;
import com.parking.costcomputation.FourWheelerCostComputation;
import com.parking.costcomputation.TwoWheelerCostComputation;
import com.parking.factory.ParkingSpotFactory;
import com.parking.gates.EntranceGate;
import com.parking.gates.ExitGate;
import com.parking.managers.ParkingSpotManager;
import com.parking.payment.CreditCardStrategy;
import com.parking.payment.UPIStrategy;
import com.parking.payment.PaymentStrategy;
import com.parking.pricing.HourlyPriceStrategy;
import com.parking.pricing.PricingStrategy;
import com.parking.spots.ParkingSpot;
import com.parking.tickets.Ticket;
import com.parking.vehicles.Vehicle;
import com.parking.enums.VehicleType;

public class ParkingLot {
    public static void main(String[] args) {
        // Initialize core components
        ParkingSpotFactory factory = new ParkingSpotFactory();
        EntranceGate entranceGate = new EntranceGate(factory);

        // Test Bike Parking
        Vehicle bike = new Vehicle(1001, VehicleType.BIKE);
        parkingDemo(entranceGate, factory, bike, new CreditCardStrategy());

        // Test Car Parking
        Vehicle car = new Vehicle(2001, VehicleType.CAR);
        parkingDemo(entranceGate, factory, car, new UPIStrategy());
    }

    private static void parkingDemo(EntranceGate entranceGate, ParkingSpotFactory factory,
                                    Vehicle vehicle, PaymentStrategy paymentStrategy) {
        try {
            System.out.println("\n=== Processing " + vehicle.getVehicleType() + " ===");

            // Entry Process
            ParkingSpot spot = entranceGate.findSpace(vehicle);
            if (spot == null) {
                System.out.println("No available spots for " + vehicle.getVehicleType());
                return;
            }

            entranceGate.bookSpot(vehicle, spot);
            Ticket ticket = entranceGate.generateTicket(vehicle, spot);
            System.out.println("Ticket generated: " + ticket.getEntryTime());

            // Simulate parking duration (2 hours)
            Thread.sleep(1000); // Represents 2 hours in real application

            // Exit Process
            ParkingSpotManager manager = factory.getParkingSpotManager(vehicle.getVehicleType());
            PricingStrategy pricing = new HourlyPriceStrategy();

            CostComputation costComputation = switch (vehicle.getVehicleType()) {
                case BIKE -> new TwoWheelerCostComputation(pricing);
                case CAR -> new FourWheelerCostComputation(pricing);
                default -> throw new IllegalArgumentException("Unsupported vehicle type");
            };

            ExitGate exitGate = new ExitGate(ticket, manager, costComputation);
            int amount = exitGate.calculatePrice();
            System.out.println("Calculated amount: ₹" + amount);

            exitGate.processPayment(amount, paymentStrategy);
            System.out.println(vehicle.getVehicleType() + " exited successfully");

        } catch (InterruptedException e) {
            System.out.println("Parking process interrupted: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error processing vehicle: " + e.getMessage());
        }
    }
}