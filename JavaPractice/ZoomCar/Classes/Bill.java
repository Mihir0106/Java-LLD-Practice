package JavaPractice.ZoomCar.Classes;

public class Bill {
    Reservation reservation;
    double totalCost;
    boolean isPaid;


    public Bill(Reservation reservation, double totalCost, boolean isPaid){
        this.reservation = reservation;
        this.totalCost = totalCost;
        this.isPaid = isPaid;
    }
}
