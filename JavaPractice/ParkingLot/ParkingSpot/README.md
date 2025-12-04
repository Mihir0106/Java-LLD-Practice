# Flow For the Parking SPot

Vehicle -> Entrance -> Ticket -> ParkingSpot -> Exit 

// Extrance Need to check for the Parking Spot availability  
// Exit will calculate cost according to the Time it stay    
// Ticket will be responsible for the vehicle to tell parking spot 

------------------------------------

    Vehicle{  
    vehicle No : Int;   
    Vehicle Type : Enum;   
    }

---------------------------------
### Single parking SPOT

    Class ParkingSpot{    
        id : int;   
        isEmpty : Boolean;   
        Vehicle : Vehicle;
        Price : double
        
        parkVehicle();
        removeVehicle();
    }

// Parking Spot will going to be 2 types     
2Wheeler and 4Wheeler   

    2WParkingParkingSpot extends ParkingSpot{   
     // Implement Method for the 2 Wheeler Parking  
     // Update price    
    }

    4WParkingSpot extends ParkingSpot {  
    // Implement Method for the 4 Wheeler parking   
    // Update price     
    }

------------------------------------------
###  Manage List of Parking Spot 

    Class ParkingSpotManager{    
        List<ParkingSpot> spots;
        ParkingStrategy strategy;
        
        ParkingSpotManager(List<ParkingSpot> spots, ParkingStrategy strategy){
            // 
            this.strategy = (strategy == null) ?  = new DefaultParkingStrategy() : strategy;
        }
        
        ParkVehicle();  
        RemoveVehicle();  

        FindParkingSpot(){
            strategy.parking();
            return null;
        };  

        AddParkingSpot();   
        RemoveParkingSpot();
    }

// Responsible for maintaining List of 2 Wheeler ParkingSPot 

    Class 2WheelerParkingManager extends ParkingManager{   
        // list of 2 wheeler spots
        List<ParkingSpot> spots;
        ParkingStrategy strategy = new nearLiftParking();
        
        2WheelerParkingManager(){
        super(spots,strategy);
    }

//Responsible for maintaining List of 4 Wheeler ParkingSPot 

    Class 4WheelerParkingManager Extends ParkingManager{   
        // List of 4 wheeler spots 
        List<ParkingSpot> spots;
        ParkingStrategy strategy;

        4WheelerParkingManager(){
        super(spots,strategy);
    }

// Implement Factory for decide which Type of parkingManager is needed for the parking  

    public Class ParkingManagerFactory{
        public ParkingManager getManager(String vehicle){
            return switch(vehicle){
                case "2Wheeler" ->  new twoWheelerParkingManager();
                case "4Wheeler" ->  new fourWheelerParkingManager();
                default -> throw new IllegralArgumentException("Unknown");
            };
        }
    }


------------------------
// Parking Strategy 
    
    interface ParkingStrategy{
        parking();
    }

    class nearLiftParking implments ParkingStrategy{
        @override
        parking(){
            // imlment logic
        }
    }

    class nearEntranceParking implments ParkingStrategy{
        @override
        parking(){
            // implement logic
        }
    }

    class Default implments ParkingStrategy{
        @override
        parking(){
            // imlment logic
        }
    }

-------------------- 

    Entrance{   
        // Determine spot according to the Vehicle type and what kind of parking vehicle wants
        Vehicle vehicle; 
        ParkingManagerFactory psManagerfactory;
        ParkingManager psManager; 

        Ticket ticletObj;
        
        // FInd Parking Spot for finding spot we need vehicle
        FindParkingSpot(Vehicle){
            psManagerfactory = new ParkingManagerFactort();
            psManager = psManagerfactory.getManager(Vehicle);
            psManager.findParkingSpot();
            parkingSpot spot = BookSpot();
            
            ticketObj.genrateTiclet(vehicle,spot);
        }
        
        // Book ParkingSPot 
        BookSpot(){
            parkingSpot = psManager.parkVehicle(vehicle);
        }

        generateTicket(Vehicle, parkingSpot){
            // generate Ticlet;
        }
        



    }

-------------------------

    Ticket{     
        EntryTime : int;  
        Vehicle : vehicle  // need to determine create ticket  
        Parking Spot // for which spot we are creating ticket   
    }


-----------------------

    class ExitGate{
        Ticket ticketObj;
        EndTime : long;
        CostComputation costCalc; 
        
        ExitGate(){
            costCalc.priceCall();
        }

        removeVehicle();
    }

------------------------

    Class CostCalculatorFactory{
        public CostCalculator getCalculator(Ticket tic){
            return Switch(tic.vehicle){
                case "twoWheeler" ->  return new CostCalculatortwoWheller();
                case "fourWheeler" ->  return new CostCalculatorfourWheller();
                default -> Exception;
            }
        }
    }

    Abstract class CostCalculator{
        PricingStrategy strategy;
        public void CostCalcular(PricingStrategy strategy){
            this.strategy = strategy;
        };
    }
    
    twoWhellerCostCaluctor extends CostCalculator{
        public void twoWhellerCostCaluctor{
            super(minutes)
        }

    }

---------------------------
    Interface PricingStrategy{
        void price(Ticket tc);        
    }

    class default implements PricingStrategy{
        void price(Ticket tc){
            return 100;
        }
    } 

    class minutes implements PricingStrategy{
        void price(Ticket tc){
            //Implementation 
        }
    } 

    class hours implements PricingStrategy{
        void price(Ticket tc){
            // Implmentation
        }
    } 








