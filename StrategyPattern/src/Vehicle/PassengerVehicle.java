package StrategyPattern.src.Vehicle;

import DriveStrategy.normalDrive;

public class PassengerVehicle extends EngineVehicle{

    public PassengerVehicle(){
        super(new normalDrive());
    }

}
