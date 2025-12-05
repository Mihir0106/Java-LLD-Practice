package JavaPractice.ZoomCar.Classes;

public class Vehicle {
    int VehicleId;
    String VehicleNumber;
    String VehicleName;
    Double CostPerHour;

    public Vehicle(int vehicleId, String vehicleName, String vehicleNumber, Double costPerHour){
        this.VehicleId = vehicleId;
        this.VehicleName = vehicleName;
        this.VehicleNumber = vehicleNumber;
        this.CostPerHour = costPerHour;
    }

    public int getVehicleId() {
        return VehicleId;
    }

}
