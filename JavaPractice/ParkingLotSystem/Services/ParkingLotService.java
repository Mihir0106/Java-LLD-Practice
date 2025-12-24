package JavaPractice.ParkingLotSystem.Services;

import JavaPractice.ParkingLotSystem.Entity.User;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingService;
import JavaPractice.ParkingLotSystem.Manager.ParkingLotManager;


public class ParkingLotService implements IParkingService {

    ParkingLotManager parkingLotManager;

    public ParkingLotService(ParkingLotManager parkingLotManager){
        this.parkingLotManager = parkingLotManager;
    }

    @Override
    public boolean isParkingSpotAvailable(Vehicle vehicle) {
        return parkingLotManager.isParkingAvailable(vehicle);
    }

    @Override
    public void ParkVehicle(User user) {
        parkingLotManager.ParkVehicle(user.getVehicle());
    }

    @Override
    public void unParkVehicle(User user) {
        parkingLotManager.unParkVehicle(user.getVehicle());

    }
}
