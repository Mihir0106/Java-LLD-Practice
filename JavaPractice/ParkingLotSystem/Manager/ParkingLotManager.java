package JavaPractice.ParkingLotSystem.Manager;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingStrategy;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLotManager {
    IParkingStrategy parkingStrategy;
    List<LevelManager> levelManagerList;
    Map<Vehicle,ParkingSpot> occupiedSpot;
    int currentCount = 0;

    public ParkingLotManager(IParkingStrategy parkingStrategy){
        this.parkingStrategy = parkingStrategy;

        levelManagerList = new LinkedList<>();
        occupiedSpot = new ConcurrentHashMap<>();
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

    public void ParkVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingStrategy.parkVehicle(levelManagerList,vehicle);

        if(spot == null) {
            System.out.println("parking spot Not available");
            throw new NoSuchElementException();
        }
        spot.parkVehicle(vehicle);
        occupiedSpot.put(vehicle,spot);
    }

    public void unParkVehicle(Vehicle vehicle){
        ParkingSpot vacateSpot = null;
        if(occupiedSpot.get(vehicle) != null) {
            vacateSpot = occupiedSpot.get(vehicle);
        }
        if(vacateSpot == null) return;

        for(LevelManager manager : levelManagerList){
            if(manager.levelId == vacateSpot.getLevelId()){
                manager.vacateParkingSpot(vacateSpot);
                break;
            }
        }
    }



}
