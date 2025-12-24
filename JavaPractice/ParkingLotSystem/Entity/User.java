package JavaPractice.ParkingLotSystem.Entity;

public class User {
    Vehicle vehicle;
    long userId;
    String userName;

    public User(long userId, String userName, Vehicle vehicle){
        this.vehicle = vehicle;
        this.userId = userId;
        this.userName = userName;
    }

    public Vehicle getVehicle(){
        return this.vehicle;
    }
}
