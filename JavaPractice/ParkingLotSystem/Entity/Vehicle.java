package JavaPractice.ParkingLotSystem.Entity;

import JavaPractice.ParkingLotSystem.Enum.VehicleType;

public class Vehicle {
    VehicleType vehicleType;
    long vehicleNumber;
    String vehicleName;

    public Vehicle(VehicleType vehicleType, long vehicleNumber,String vehicleName){
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType(){
        return  vehicleType;
    }
}
