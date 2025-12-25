package JavaPractice.VendingMachine.Enums;

public enum Currency {
    One(1),
    Five(5),
    Ten(10),
    Twenty(20);

    private final int value;

    Currency(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
