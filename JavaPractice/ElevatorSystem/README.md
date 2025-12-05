# Elevator System

Building has a Floors   
Each Floor has a LiftGate and ExternalButton (to call List)     
Button has a Lift (on click Button Lift movement trigger)       
External Display has a Lift status and Direction to show        


Lift has a Button (to click for next floor)  
Lift has a Direction ( Up or Down)      
Lift has a Display (to show current Floor) 
Lift has a Status (Moving or stationary)
List has a CurrentFlow info


## Questions
- No of Lift ? ans : n
- Lift Dispatch Algo ?  ans : i need functionality to implement algo i want Extension 


### Objects that i found  
- Building 
- Floor 
- Elevator
- Door
- Display
- Button


----------------
### Display

    class Display {
        - currentFloor
        - Direction
    }

---------------
### Elevator

    Class Elevator{
        - ELevatorId
        - CurrentFloor 
        - Display 
        - Direction : enum {Up, Down}
        - Status : enum {Idle, Moving}
        - List<Button> // Floor Buttons
        - Door 
        + Move(int destinationFloor)
    }

---------------
### Elevator Controller

#### Think : Who will decide which elevator to move ? and who will move the elevator

-  We need 1 controller for one elevator    
-  Reason consider this as Elevator is a Car and Controller is Driver    
-  Driver is responsible for moving Car  
-  Elevator controller is responsible for the Elevator

**and**  

- Elevator System is responsible to tell Elevator controller to move elevator
- ElevatorSystem has a List of Elevator Controller and Elevator Controller has a Elevator



    Class ElevatorController{
        - Elevator elevators;
        - PriorityQueue<Integer> Upword
        - PriorityQueue<Integer> downward
        + submitnewDispatchRequest(int floor, Enum Direction) ?? do we need to add Direction as parameter ?
        + ControlElevator() // Move 
    }




---------------
### Button 

Class Button{ // this should be Interface or not ?  
    + PressButton()
}

Class ExternalButton extends Button{
    - ExternalButtonDispatcher
    + PressButton(int button)
}

Class InternalButton extends Button{
    - InternalButtonDispatcher
    + PressButton(int button)

}

---------------------
### Button Dispatcher 

internalButtonDispatcher{
    - List<ElevatorController>
    + SubmitRequest(ElevatorId, int floorNo)
}

externalButtonDispatcher{
    - List<ElevatorController>
    - DispatcherStrategy
    + SubmitRequest(currentFloorNo, Direction) 
}

Interface DispatcherStrategy{
    + Dispatch(List<ElevatorController>, currentFloor, Direction);
}

OddEvenDispatcher implements DispatcherStrategy {
    // Implementation 
}

FixedFloorDispatcher implements DispatcherStrategy {
    // Implementation
}

---------------------
### Floor 

class Floor{    
    - FloorId;
    - ExternalButton;

}


---------------------
### Building 

class Building {
    - List<Floor>
}

---------------------
- SCAN Algorithm   
 if it goes up and take request for upward till end and then 
- fo down till end and then repeat 


Look Algorithm 
    check for the next if any request then proceed or else go down  