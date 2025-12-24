package JavaPractice.GithubSample.ParkingLot.strategy.fee;

import JavaPractice.GithubSample.ParkingLot.entities.ParkingTicket;

public interface FeeStrategy {
    double calculateFee(ParkingTicket parkingTicket);
}
