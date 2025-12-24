package JavaPractice.ParkingLotSystem.ParkingStrategies;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingStrategy;
import JavaPractice.ParkingLotSystem.Manager.LevelManager;
import JavaPractice.ParkingLotSystem.Manager.ParkingLotManager;

import java.util.List;
import java.util.Queue;

public class NormalParkingStrategy implements IParkingStrategy {


    @Override
    public Boolean isParkingAvailable(List<LevelManager> levelManagerList, Vehicle vehicle) {
        for(LevelManager level : levelManagerList){
            Queue<ParkingSpot> available = level.getParkingSpotList(vehicle);
            if(!available.isEmpty()){
                return true;
            }
        }
        return false;
    }

    @Override
    public ParkingSpot parkVehicle(List<LevelManager> levelManagerList,Vehicle vehicle) {
        for(LevelManager level : levelManagerList){
            Queue<ParkingSpot> available = level.getParkingSpotList(vehicle);
            if(!available.isEmpty()){
                return available.poll();
            }
        }
        return null;
    }



}
