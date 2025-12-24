package JavaPractice.ParkingLotSystem.Entity;

import JavaPractice.ParkingLotSystem.Enum.VehicleType;

public class ParkingSpot {
    Vehicle vehicle;
    VehicleType parkingSpotType;
    int levelId;


    public ParkingSpot(VehicleType parkingSpotType){
        this.parkingSpotType = parkingSpotType;
    }

    public void AssignLevel(int levelId){
        this.levelId = levelId;
    }

    public int getLevelId(){
        return levelId;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public VehicleType getParkingSpotType(){
        return  parkingSpotType;
    }

    public void parkVehicle(Vehicle vehicle){
        System.out.println("Vehicle " + vehicle.vehicleName + " is parked");
        this.vehicle = vehicle;
    }

    public void removeVehicle(){
        System.out.println("Vehicle " + vehicle.vehicleName + " is removed");
        this.vehicle = null;
    }
}
