package JavaPractice.ParkingLotSystem.Manager;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Enum.VehicleType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LevelManager {

    List<ParkingSpot> parkingSpotList;
    Map<VehicleType, Queue<ParkingSpot>> availableSpot;
    int levelId;

    public LevelManager() {
        this.parkingSpotList = new LinkedList<>();
        this.availableSpot = new ConcurrentHashMap<>();
    }

    public void AddParkingSpot(ParkingSpot parkingSpot) {
        parkingSpotList.add(parkingSpot);
        parkingSpot.AssignLevel(levelId);

        availableSpot.computeIfAbsent(parkingSpot.getParkingSpotType(), k -> new ConcurrentLinkedQueue<>());
        availableSpot.get(parkingSpot.getParkingSpotType()).offer(parkingSpot);
    }

    public void AssignLevelId(int id) {
        levelId = id;
    }

    public Queue<ParkingSpot> getParkingSpotList(Vehicle vehicle) {

        Queue<ParkingSpot> queue = availableSpot.get(vehicle.getVehicleType());
        return queue != null ? queue : new ConcurrentLinkedQueue<>();
    }

    public void vacateParkingSpot(ParkingSpot vacateSpot) {
        for (ParkingSpot spot : parkingSpotList) {
            if (spot == vacateSpot) {
                vacateSpot.removeVehicle();
                availableSpot.get(spot.getParkingSpotType()).offer(spot);
            }
        }
    }

}
