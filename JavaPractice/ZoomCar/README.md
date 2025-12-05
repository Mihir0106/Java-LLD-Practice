# Zoom Car - Rental Car System 

## Problem Statement: Design a Self-Drive Car Rental System
**Context**: We need to design an object-oriented system for a self-drive car rental service (similar to ZoomCar or Zipcar). Users can browse available cars, book them for a specific duration, and pick them up from designated stations.

**Functional Requirements**:
- Vehicle Inventory Management:
- The system must support different types of vehicles (e.g., Hatchback, SUV, Sedan).
- Each vehicle belongs to a specific Station (Location).
- Vehicles have attributes like license plate, mileage, manufacturing year, and status (Available, Booked, Under Maintenance).

**Search & Reservation**:
- Users should be able to search for available vehicles based on a Pick-up Location and a Date/Time Range (Start Time, End Time).
- The system should only display vehicles that are available for the entire requested duration.

**Booking Workflow**:
- Users can book a specific vehicle.
- A booking creates a reservation in the system.
- The system must handle concurrency: Two users cannot book the same car for overlapping time slots.

**Pricing & Payment**:
- Different vehicle types have different hourly rates.
- Users can add Add-ons to their booking (e.g., GPS Navigation, Baby Seat) which cost extra.
- The system should calculate the estimated total cost upon booking.
- Support for payment processing (Stub/Interface only).

**Rental Lifecycle**:
- Pickup: User scans a barcode/enters a code to start the ride.
- Return: User returns the car to the station.
-Late Fees: If the car is returned after the agreed end time, a penalty fee should be calculated.

**Key Technical Constraints & Expectations**:
- Design Patterns: Demonstrate appropriate use of patterns (e.g., Factory for Vehicle creation, Strategy for Pricing, Singleton for Inventory Manager).
- Extensibility: The code should be open to adding new vehicle types or pricing strategies (e.g., surge pricing) without major refactoring.
- Code Quality: Proper naming conventions, modularity, and handling of edge cases.
- Thread Safety: Handling the race condition where two users try to book the last SUV simultaneously.

--------------------
Flow :
 user -> Enter app -> go to inventory -> select Car -> Book a Vehicle ->  payment -> select from the location 

// Search 
user -> Location -> Store -> Vehicle

//Reserve
Vehicle -> Reserve ->Bill ->  Payment

//Complete
user -> Vehicle -> got the Vehicle / Submit 


--------------------

### Requirement Clarification 

-  we make it for car only ? ans - lets make it scalable 

--------------------

### objects 

User 
Location 
Store 
Vehicle 
Reserve
Bill 
Payment 

--------------------
## Classes 
--------------------

### location 
    
    Class Location{
        - Latitude : double
        - longitude : double
        - Address 
        - City
        - Pincode
    }

--------------------
### BookingPeriod

    Class BookingPeriod{
        - StartTime : long
        - Endtime : long
    }

--------------------
### User

    Class User{
        - userName : String
        - DrivingLicense : String 
        - UserId :long
    }

---------------------

### Store

    Class Store{
        - StoreId : long  // not a single Store, need identifcation 
        - VehicleInventory : Obj
        - Location : location 
        - List<Reservation> : 
    }


---------------------
### Vehicle Inventory
    // To avoid bulkUp in Store class
    Class VehicleInventory{
    - List<Vehicle>
    // Crud Operation 
    + SelectVehicle()
    + UnselectVehicle()
    + AddVehicle()
    + RemoveVehicle()
        
    }


---------------------
### Vehicle 
    
     Class Vehicle{
        - VehicleId : String
        - VehicleNo : String
        - VehicleName : String
        - VehicleType : enum 
        - Status : enum
        - Price : Double
        - Location : Location obj
        // getter for all of these 
    }


---------------------
### Reservation
// is this unique   
// Who making reservation   
// for what making reservation  
// reservation has one status/state only
// for where we are making reservation 

    Class Reservation{
        - ReservationId : long
        - User : USer Obj
        - Vehicle : Vehicle obj 
        - Time : BookingPeriod
        - ReservationStatus : enum
        + generateBill(Vehicle, Time)
    }

//Reservation Enum 

    Class ReservationStatus{
        Scheduled,
        InProgress,
        Completed,
        Canceled

---------------------
### Bill 

    Class Bill{ 
        - Reservation : Reservation Obj // Gemerate bill against a reservation
        - CostCalculator : CostCalutorObj
        - isPaid : boolean 
        -TotalCost  : double 

    }

---------------------
### CalculateCost 

    Class CalculateBill{
        // Do the Implmentation for the cost 
    }

---------------------
### Payment 
    
    Class Payment {
     - Bill : billObj
     + PayBill();
    }


---------------------

## Systems/Services Classes
--------------------

### Vehicle Rental System 

VehicleRentalSystem(){
    - List<Users> 
    - List<Store>
    + CRUD operations for Users and Store
}

BookingService(){
    + Check Availability() //Requirement : Request time and date From when to when
    according to location determine store then check for availability in the store
}






