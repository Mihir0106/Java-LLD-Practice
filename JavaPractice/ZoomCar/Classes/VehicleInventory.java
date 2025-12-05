package JavaPractice.ZoomCar.Classes;

import java.util.LinkedList;
import java.util.List;

public class VehicleInventory {
    List<Vehicle> vehicleList;

    public VehicleInventory(){
        vehicleList = new LinkedList<>();
    }


    //CRUD Operation
    //Create
    public void AddNewVehicle(int vehicleId, String vehicleName, String vehicleNumber, Double costPerHour){
        Vehicle vehicle = new Vehicle(vehicleId,vehicleName,vehicleNumber,costPerHour);
        vehicleList.add(vehicle);
    }

    public Vehicle GetVehicle(int vehicleId){
        for(Vehicle item : vehicleList){
            if(item.getVehicleId() == vehicleId){
                return item;
            }
        }

        return null;
    }

    //Update Operation
    //Delete Operation

}
