package JavaPractice.ParkingLotSystem.Manager;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Enum.VehicleType;

import java.util.*;

public class LevelManager {

    List<ParkingSpot> parkingSpotList;
    Map<VehicleType, Queue<ParkingSpot>> availableSpot;
    int levelId;

    public LevelManager(){
        this.parkingSpotList = new LinkedList<>();
    }

    public void AddParkingSpot(ParkingSpot parkingSpot){
        parkingSpotList.add(parkingSpot);
        parkingSpot.AssignLevel(levelId);
    }

    public void AssignLevelId(int id){
        levelId = id;
    }

    public Queue<ParkingSpot> getParkingSpotList(Vehicle vehicle){
        if(availableSpot == null){
            availableSpot = new HashMap<>();

            for(ParkingSpot spot : parkingSpotList){
                if(spot.isAvailable()){
                    availableSpot.computeIfAbsent(spot.getParkingSpotType(), k -> new LinkedList<>());
                    availableSpot.get(spot.getParkingSpotType()).offer(spot);
                }
            }
        }
        return availableSpot.get(vehicle.getVehicleType());
    }

    public void vacateParkingSpot(ParkingSpot vacateSpot){
        for(ParkingSpot spot : parkingSpotList){
            if(spot == vacateSpot){
                vacateSpot.removeVehicle();
                availableSpot.get(spot.getParkingSpotType()).offer(spot);
            }
        }
    }

}
