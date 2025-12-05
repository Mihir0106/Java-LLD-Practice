package JavaPractice.ZoomCar;

import JavaPractice.ZoomCar.Classes.Location;
import JavaPractice.ZoomCar.Classes.Store;
import JavaPractice.ZoomCar.Classes.User;

import java.util.List;

public class RentalService {
    List<User> users;
    List<Store> stores;

    public RentalService(List<User> users, List<Store> stores){
        this.stores = stores;
        this.users = users;
    }

    public Store GetStore(int pinCode){
        for(Store store : stores){
            if(store.getLocation().getPinCode() == pinCode){
                return  store;
            }
        }
        return null;
    }

}
