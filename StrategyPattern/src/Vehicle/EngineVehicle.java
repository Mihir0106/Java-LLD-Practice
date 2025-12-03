package StrategyPattern.src.Vehicle;

import Interfaces.DriveStrategy;

public class EngineVehicle extends Vehicle {
    DriveStrategy driveStrategy;

    public EngineVehicle(DriveStrategy driveStrategy){
        super(driveStrategy);
        this.driveStrategy = driveStrategy;
    }
}
