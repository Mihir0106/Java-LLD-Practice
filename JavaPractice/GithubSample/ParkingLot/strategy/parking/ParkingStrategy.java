package JavaPractice.GithubSample.ParkingLot.strategy.parking;

import JavaPractice.GithubSample.ParkingLot.entities.ParkingFloor;
import JavaPractice.GithubSample.ParkingLot.entities.ParkingSpot;
import JavaPractice.GithubSample.ParkingLot.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public interface ParkingStrategy {
    Optional<ParkingSpot> findSpot(List<ParkingFloor> floors, Vehicle vehicle);
}
