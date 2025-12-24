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

public class Program {
    static void main() {
        ParkingLotManager parkingLotManager = getParkingLotManager();

        IParkingService parkingService = new ParkingLotService(parkingLotManager);
        User a = new User(12345,"Mihir", new Vehicle(VehicleType.Car,1234567,"BMW"));
        parkingService.ParkVehicle(a);

        parkingService.ParkVehicle(new User(1235,"Mihir Jain", new Vehicle(VehicleType.Bike,1237,"360")));

        parkingService.unParkVehicle(a);

        parkingService.ParkVehicle(new User(12345,"Mihir", new Vehicle(VehicleType.Car,1234447,"MMM")));

    }

    private static ParkingLotManager getParkingLotManager() {
        ParkingSpot spot1 = new ParkingSpot(VehicleType.Car);
        ParkingSpot spot2 = new ParkingSpot(VehicleType.Bike);

        LevelManager levelManager = new LevelManager();
        levelManager.AddParkingSpot(spot1);
        levelManager.AddParkingSpot(spot2);

        IParkingStrategy parkingStrategy = new NormalParkingStrategy();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingStrategy);
        parkingLotManager.addLevel(levelManager);
        return parkingLotManager;
    }

}
