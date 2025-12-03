package StrategyPattern.src.Vehicle;

import DriveStrategy.SpecialDrive;
import StrategyPattern.src.Vehicle.EngineVehicle;

public class SportsVehicle extends EngineVehicle {

    public SportsVehicle(){
        super(new SpecialDrive());
    }
}
