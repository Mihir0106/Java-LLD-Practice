package JavaPractice.ZoomCar.Classes;

import java.util.List;

public class Store {
    VehicleInventory inventory;
    List<Reservation> reservation;
    Location location;


    public Location getLocation() {
        return location;
    }

    public Store(Location location, VehicleInventory inventory){
        this.inventory =  inventory;
        this.location = location;
    }

    boolean CreateReservation(){

        return false;
    }


}
