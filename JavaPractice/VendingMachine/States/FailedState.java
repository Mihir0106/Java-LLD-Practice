package JavaPractice.VendingMachine.States;

import JavaPractice.VendingMachine.Enums.TransactionState;
import JavaPractice.VendingMachine.Interface.IState;
import JavaPractice.VendingMachine.VendingMachine;

public class FailedState implements IState {
    VendingMachine machine;

    @Override
    public void available(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void performingTransaction(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void transactionComplete(VendingMachine machine) {
        this.machine = machine;
        // Transaction failed
        machine.ChangeState(new FailedState());
    }

    @Override
    public void transactionFailed(VendingMachine machine) {
        this.machine = machine;
        // Refund User balance
        // Restock Product

    }
}
