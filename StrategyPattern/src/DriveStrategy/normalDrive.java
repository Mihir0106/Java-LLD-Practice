package DriveStrategy;

import Interfaces.DriveStrategy;

public class normalDrive implements DriveStrategy {

    @Override
    public void drive(){
        System.out.println("Normal Drive");
    }
}
