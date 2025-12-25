package JavaPractice.VendingMachine.Enums;

public enum TransactionState {
    NOTEnoughMoney("NOT ENOUGH MONEY "),
    NoReturnRequired( "NO return Needed "),
    ReturnRequired ("Return Required ");


    String value;

    TransactionState(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
