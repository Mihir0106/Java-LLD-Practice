package JavaPractice.ParkingLotSystem.Manager;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingStrategy;
import JavaPractice.ParkingLotSystem.Services.ParkingLotService;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class ParkingLotManager {
    IParkingStrategy parkingStrategy;
    List<LevelManager> levelManagerList;
    int currentCount = 0;

    public ParkingLotManager(IParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;

        levelManagerList = new LinkedList<>();
    }

    public void addLevel(LevelManager levelManager){
        levelManagerList.add(levelManager);
        levelManager.AssignLevelId(currentCount);
        currentCount++;
    }

    public void RemoveLevelManager(LevelManager level){
        levelManagerList.remove(level);
    }

    public boolean isParkingAvailable(Vehicle vehicle){
        return parkingStrategy.isParkingAvailable(levelManagerList,vehicle);
    }

    public ParkingSpot ParkVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingStrategy.parkVehicle(levelManagerList,vehicle);

        if(spot == null) {
            System.out.println("parking spot Not available");
            throw new NoSuchElementException();
        }
        spot.parkVehicle(vehicle);
        return spot;
    }

    public void unParkVehicle(ParkingSpot vacateSpot){
        for(LevelManager manager : levelManagerList){
            if(manager.levelId == vacateSpot.getLevelId()){
                manager.vacateParkingSpot(vacateSpot);
                break;
            }
        }
    }



}
