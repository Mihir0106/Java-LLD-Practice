package JavaPractice;

import DriveStrategy.SpecialDrive;
import JavaPractice.helloworld.handyClass;
import SOLIDPrinciplesPractice.LSP.ShapesAreaCalculator;
import SOLIDPrinciplesPractice.LSP.shapes.circle;
import StrategyPattern.src.Vehicle.*;

public class practice {
    public static void main(String[] args){
//        handyClass.helloWorld();
       // circle
        StrategyPattern.src.Vehicle.Vehicle vehicle = new SportsVehicle();
        vehicle.drive();


        StrategyPattern.src.Vehicle.Vehicle vehicle2 = new PassengerVehicle();
        vehicle2.drive();
    }
}
