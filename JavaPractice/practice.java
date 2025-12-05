package JavaPractice;

import JavaPractice.ZoomCar.Classes.*;
import JavaPractice.ZoomCar.RentalService;

import java.util.LinkedList;
import java.util.List;


public class practice {
    public static void main(String[] args){
        //handyClass.helloWorld();

        RentalService rentalService = SetupRentalService();

        Store store = rentalService.GetStore(560035);



    }

    public static RentalService SetupRentalService(){
        User user = new User("Mihir","1q2w3e4r");

        Location location = new Location("Sri Sai IKon", "Karnataka", 560035);

        VehicleInventory inventory = new VehicleInventory();

        inventory.AddNewVehicle(9654,"Sedan","KA01KH",100.0);

        Store store = new Store(location,inventory);

        List<User> users = new LinkedList<>();
        users.add(user);

        List<Store> stores = new LinkedList<>();
        stores.add(store);

        return new RentalService(users,stores);
    }
}
