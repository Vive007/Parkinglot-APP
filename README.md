

```markdown
# Parking Lot Low-Level Design (LLD)

A Java implementation of a parking lot system demonstrating Object-Oriented Design principles and common design patterns.

## 🚀 Features

- **Vehicle Type Support**: Handles 2-wheeler (BIKE) and 4-wheeler (CAR) vehicles
- **Dynamic Pricing Strategies**: Hourly/Minute-wise pricing models
- **Multiple Parking Strategies**: 
  - Near Entrance First
  - Near Elevator/Exit
  - Random Allocation
- **Payment Integration**: Credit Card/UPI payment support
- **Cost Calculation**: Vehicle-type specific pricing with duration-based computation
- **Factory Pattern**: Object creation management for parking spots

## 🧠 Design Patterns Used

| Pattern           | Implementation Example                |
|-------------------|---------------------------------------|
| **Strategy**      | Parking allocation/Pricing algorithms|
| **Factory**       | ParkingSpotManager creation          |
| **Template Method**| Cost computation hierarchy           |
| **Composition**   | ParkingSpot management               |
| **Interface Segregation** | Payment strategies          |

## 📈 Optimal Data Structures

1. **ArrayList** for parking spot management
   - O(1) access for first/last element operations
   - Efficient for frequent add/remove operations
2. **Enums** for type safety
   - `VehicleType` (CAR, BIKE, BUS)
   - `SpotType` (TWO_WHEELER, FOUR_WHEELER)
3. **Stream API** for parking spot selection
   - Efficient filtering and sorting
4. **Millisecond Precision** for duration calculation
   - Using `System.currentTimeMillis()`
```

## 🏗️ Class Diagram

```bash
@startuml
skinparam classAttributeIconSize 0
skinparam packageStyle rectangle
left to right direction

package "com.parking.enums" {
    enum SpotType {
        TWO_WHEELER
        FOUR_WHEELER
    }
    
    enum VehicleType {
        CAR
        BUS
        BIKE
    }
}

package "com.parking.spots" {
    abstract class ParkingSpot {
        - parkingSpotId : int
        - parkingPrice : int
        - spotType : SpotType
        - isAvailable : boolean
        - vehicle : Vehicle
        + parkVehicle(Vehicle)
        + removeVehicle()
        + getParkingSpotId() : int
        + isAvailable() : boolean
    }
    
    class TwoWheelerSpot {
        + TwoWheelerSpot(int, int)
        + price() : int
    }
    
    class FourWheelerSpot {
        + FourWheelerSpot(int, int)
        + price() : int
    }
}

package "com.parking.managers" {
    abstract class ParkingSpotManager {
        # parkingList : List<ParkingSpot>
        # parkingStrategy : ParkingStrategy
        + ParkingSpotManager(List<ParkingSpot>, ParkingStrategy)
        + findParkingSpace() : ParkingSpot
        + addParkingSpace(ParkingSpot)
        + removeParkingSpace(ParkingSpot)
        + parkVehicle(Vehicle, ParkingSpot)
        + removeVehicle(ParkingSpot)
    }
    
    class TwoWheelerManager {
        + TwoWheelerManager(List<ParkingSpot>, ParkingStrategy)
    }
    
    class FourWheelerManager {
        + FourWheelerManager(List<ParkingSpot>, ParkingStrategy)
    }
}

package "com.parking.strategy" {
    interface ParkingStrategy {
        + findSpot(List<ParkingSpot>) : ParkingSpot
    }
    
    class NearToEntranceStrategy {
        + findSpot(List<ParkingSpot>) : ParkingSpot
    }
    
    class NearToEndAndElevatorStrategy {
        + findSpot(List<ParkingSpot>) : ParkingSpot
    }
    
    class DefaultStrategy {
        + findSpot(List<ParkingSpot>) : ParkingSpot
    }
}

package "com.parking.vehicles" {
    class Vehicle {
        - vehicleNo : int
        - vehicleType : VehicleType
        + Vehicle(int, VehicleType)
        + getVehicleNo() : int
        + getVehicleType() : VehicleType
    }
}

package "com.parking.tickets" {
    class Ticket {
        - entryTime : long
        - vehicle : Vehicle
        - parkingSpot : ParkingSpot
        + Ticket(long, Vehicle, ParkingSpot)
        + getEntryTime() : long
        + getVehicle() : Vehicle
        + getParkingSpot() : ParkingSpot
    }
}

package "com.parking.factory" {
    class ParkingSpotFactory {
        + getParkingSpotManager(VehicleType) : ParkingSpotManager
    }
}

package "com.parking.gates" {
    class EntranceGate {
        - parkingSpotFactory : ParkingSpotFactory
        + EntranceGate(ParkingSpotFactory)
        + findSpace(Vehicle) : ParkingSpot
        + bookSpot(Vehicle, ParkingSpot)
        + generateTicket(Vehicle, ParkingSpot) : Ticket
    }
    
    class ExitGate {
        - ticket : Ticket
        - parkingSpotManager : ParkingSpotManager
        - costComputation : CostComputation
        + ExitGate(Ticket, ParkingSpotManager, CostComputation)
        + calculatePrice() : int
        + processPayment(int, PaymentStrategy)
    }
}

package "com.parking.payment" {
    interface PaymentStrategy {
        + pay(int)
    }
    
    class CreditCardStrategy {
        + pay(int)
    }
    
    class UPIStrategy {
        + pay(int)
    }
}

package "com.parking.pricing" {
    interface PricingStrategy {
        + calculatePrice(long) : int
    }
    
    class HourlyPriceStrategy {
        + calculatePrice(long) : int
    }
    
    class MinuteWisePriceStrategy {
        + calculatePrice(long) : int
    }
}

package "com.parking.costcomputation" {
    abstract class CostComputation {
        # pricingStrategy : PricingStrategy
        + CostComputation(PricingStrategy)
        + computeCost(long) : int
    }
    
    class TwoWheelerCostComputation {
        + TwoWheelerCostComputation(PricingStrategy)
        + computeCost(long) : int
    }
    
    class FourWheelerCostComputation {
        + FourWheelerCostComputation(PricingStrategy)
        + computeCost(long) : int
    }
}

' Inheritance Relationships
ParkingSpot <|-- TwoWheelerSpot
ParkingSpot <|-- FourWheelerSpot
ParkingSpotManager <|-- TwoWheelerManager
ParkingSpotManager <|-- FourWheelerManager

ParkingStrategy <|-- NearToEntranceStrategy
ParkingStrategy <|-- NearToEndAndElevatorStrategy
ParkingStrategy <|-- DefaultStrategy

PaymentStrategy <|-- CreditCardStrategy
PaymentStrategy <|-- UPIStrategy

PricingStrategy <|-- HourlyPriceStrategy
PricingStrategy <|-- MinuteWisePriceStrategy

CostComputation <|-- TwoWheelerCostComputation
CostComputation <|-- FourWheelerCostComputation

' Composition/Association Relationships
ParkingSpotManager *-- ParkingSpot : manages
ParkingSpotManager o-- ParkingStrategy : uses

EntranceGate o-- ParkingSpotFactory : uses
EntranceGate ..> Ticket : creates

ExitGate o-- ParkingSpotManager : uses
ExitGate o-- CostComputation : uses
ExitGate ..> PaymentStrategy : uses

CostComputation o-- PricingStrategy : uses

Ticket *-- Vehicle : contains
Ticket *-- ParkingSpot : contains

Vehicle o-- VehicleType : has
ParkingSpot o-- SpotType : has

ParkingSpotFactory --> ParkingSpotManager : creates
ParkingSpotFactory --> TwoWheelerSpot : creates
ParkingSpotFactory --> FourWheelerSpot : creates

' Dependency Relationships
TwoWheelerCostComputation ..> HourlyPriceStrategy : uses
FourWheelerCostComputation ..> HourlyPriceStrategy : uses

note top of ParkingSpotManager
  Manages collection of parking spots
  using configured allocation strategy
end note

note right of ParkingStrategy
  Implements different allocation algorithms:
  - Nearest to entrance
  - Near elevator/exit
  - Random selection
end note

note bottom of CostComputation
  Combines vehicle type multiplier
  with pricing strategy
end note

@enduml
```
## 🏗️ Class Diagram Image
![parkingLot](https://github.com/user-attachments/assets/2189051e-8d45-4d1b-9563-bf2aac02cd93)

_Generate diagram using [PlantText](https://www.planttext.com/) or VSCode PlantUML extension_

## ⚙️ Installation

**Requirements**:
- JDK 17+
- Maven/Gradle (optional)

```bash
# Clone repository
git clone https://github.com/Vive007/ParkinglotLLd.git
```
```bash
# Compile
javac -d . com/parking/*.java com/parking/**/*.java

# Run
java com.parking.Main
```

## 🧪 Usage Example

```java
// Entry Process
ParkingSpotFactory factory = new ParkingSpotFactory();
EntranceGate entrance = new EntranceGate(factory);

Vehicle car = new Vehicle(1001, VehicleType.CAR);
ParkingSpot spot = entrance.findSpace(car);
entrance.bookSpot(car, spot);
Ticket ticket = entrance.generateTicket(car, spot);

// Exit Process
PricingStrategy pricing = new HourlyPriceStrategy();
CostComputation costCalc = new FourWheelerCostComputation(pricing);

ExitGate exit = new ExitGate(ticket, factory.getParkingSpotManager(VehicleType.CAR), costCalc);
int amount = exit.calculatePrice();
exit.processPayment(amount, new CreditCardStrategy());
```

## 🧩 Key Components

| Component             | Description                                  |
|-----------------------|----------------------------------------------|
| `ParkingSpotFactory`  | Creates vehicle-specific managers           |
| `EntranceGate`        | Handles spot allocation & ticket generation |
| `ExitGate`            | Manages payment & spot release              |
| `CostComputation`     | Calculates parking fees                     |
| `PaymentStrategy`     | Payment method implementations              |

## 📚 Future Enhancements

1. Add BUS/RV vehicle support
2. Implement database persistence
3. Add multi-level parking support
4. Introduce premium parking spots
5. Add seasonal pricing strategies
6. Implement real payment gateway integration

## 👥 Contributions

Contributions welcome! Please:
1. Fork the repository
2. Create your feature branch
3. Commit changes with tests
4. Push and open a Pull Request

## 📜 License

MIT License - see [LICENSE](LICENSE) for details

---

**Acknowledgments**:  
Design inspired by LLD common interview problems  
Special thanks to PlantUML and Ai for diagram support
