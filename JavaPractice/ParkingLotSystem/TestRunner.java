package JavaPractice.ParkingLotSystem;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.User;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Enum.VehicleType;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingService;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingStrategy;
import JavaPractice.ParkingLotSystem.Manager.LevelManager;
import JavaPractice.ParkingLotSystem.Manager.ParkingLotManager;
import JavaPractice.ParkingLotSystem.ParkingStrategies.NormalParkingStrategy;
import JavaPractice.ParkingLotSystem.Services.ParkingLotService;

import java.util.*;

public class TestRunner {
    public static void main(String[] args) {
        System.out.println("=== Starting Parking Lot Tests ===");
        
        try {
            ParkingLotManager parkingLotManager = getParkingLotManager();
            IParkingService parkingService = new ParkingLotService(parkingLotManager);

            // 1. Happy Path: Park Car and Bike
            System.out.println("\n[Test 1] Parking Car and Bike...");
            User userCar = new User(1, "Alice", new Vehicle(VehicleType.Car, 101, "MyCar"));
            User userBike = new User(2, "Bob", new Vehicle(VehicleType.Bike, 202, "MyBike"));
            
            parkingService.ParkVehicle(userCar); // Should success
            parkingService.ParkVehicle(userBike); // Should success

            // 2. Unpark Car
            System.out.println("\n[Test 2] Unparking Car...");
            parkingService.unParkVehicle(userCar);
            System.out.println("Car unparked.");

            // 3. Re-park Car (Reuse spot)
            System.out.println("\n[Test 3] Re-parking Car...");
            User userCar2 = new User(3, "Charlie", new Vehicle(VehicleType.Car, 303, "NewCar"));
            parkingService.ParkVehicle(userCar2); // Should success

            // 4. Test NPE Bug: Park Truck (No spots exist for Truck)
            System.out.println("\n[Test 4] Attempting to park Truck (Expect Potential Crash)...");
            User userTruck = new User(4, "Dave", new Vehicle(VehicleType.Truck, 404, "BigTruck"));
            try {
                parkingService.ParkVehicle(userTruck);
                System.out.println("Truck parked (Unexpected if no spots).");
            } catch (NullPointerException e) {
                System.out.println("CAUGHT EXPECTED NULL POINTER EXCEPTION!");
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                 System.out.println("CAUGHT EXPECTED NoSuchElementException (Parking Full) - Logic is Robust.");
            } catch (Exception e) {
                System.out.println("Caught unexpected exception: " + e);
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("\n=== Tests Completed ===");
    }

    private static ParkingLotManager getParkingLotManager() {
        ParkingSpot spot1 = new ParkingSpot(VehicleType.Car);
        ParkingSpot spot2 = new ParkingSpot(VehicleType.Bike);
        // Note: No Truck spots added
        
        LevelManager levelManager = new LevelManager();
        levelManager.AddParkingSpot(spot1);
        levelManager.AddParkingSpot(spot2);
        
        IParkingStrategy parkingStrategy = new NormalParkingStrategy();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingStrategy);
        parkingLotManager.addLevel(levelManager);
        return parkingLotManager;
    }
}
