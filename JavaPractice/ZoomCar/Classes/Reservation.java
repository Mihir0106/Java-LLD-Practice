package JavaPractice.ZoomCar.Classes;

public class Reservation {
    User user;
    Vehicle vehicle;
    long startTime;
    long endTime;



    public Reservation(User user, Vehicle vehicle, long startTime, long endTime){
        this.user = user;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    void CostCalculation(){

    }
}
