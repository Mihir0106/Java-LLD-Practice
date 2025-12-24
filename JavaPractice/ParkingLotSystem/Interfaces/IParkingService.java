package JavaPractice.ParkingLotSystem.Interfaces;

import JavaPractice.ParkingLotSystem.Entity.User;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;

public interface IParkingService {

    boolean isParkingSpotAvailable(Vehicle vehicle);

    void ParkVehicle(User user);

    void unParkVehicle(User user);
}
