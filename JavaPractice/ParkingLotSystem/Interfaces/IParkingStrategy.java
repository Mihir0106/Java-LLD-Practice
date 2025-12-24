package JavaPractice.ParkingLotSystem.Interfaces;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Manager.LevelManager;

import java.util.List;

public interface IParkingStrategy {

    Boolean isParkingAvailable(List<LevelManager> levelManagers, Vehicle vehicle);

    ParkingSpot parkVehicle(List<LevelManager> levelManagers,Vehicle vehicle);

}
