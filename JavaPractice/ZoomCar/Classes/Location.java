package JavaPractice.ZoomCar.Classes;

public class Location {
    String Address;
    String State;
    int pinCode;

    public  Location(String address, String state, int pinCode){
        this.Address = address;
        this.State = state;
        this.pinCode = pinCode;
    }

    public int getPinCode() {
        return pinCode;
    }
}
