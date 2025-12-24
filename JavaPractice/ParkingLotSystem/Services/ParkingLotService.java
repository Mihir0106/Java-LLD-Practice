package JavaPractice.ParkingLotSystem.Services;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.User;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingService;
import JavaPractice.ParkingLotSystem.Manager.ParkingLotManager;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ParkingLotService implements IParkingService {

    ParkingLotManager parkingLotManager;
    Map<Vehicle,ParkingSpot> occupiedSpot;

    public ParkingLotService(ParkingLotManager parkingLotManager){
        this.parkingLotManager = parkingLotManager;
        occupiedSpot = new HashMap<>();
    }

    @Override
    public boolean isParkingSpotAvailable(Vehicle vehicle) {
        return parkingLotManager.isParkingAvailable(vehicle);
    }

    @Override
    public void ParkVehicle(User user) {
        ParkingSpot spot;
        spot = parkingLotManager.ParkVehicle(user.getVehicle());
        if(spot == null) {
            System.out.println("Parking Not available");
            return;
        }
        occupiedSpot.put(user.getVehicle(),spot);
    }


    @Override
    public void unParkVehicle(User user) {
        if(occupiedSpot.get(user.getVehicle()) != null) {
            ParkingSpot spot = occupiedSpot.get(user.getVehicle());
            parkingLotManager.unParkVehicle(spot);
        }
    }
}
