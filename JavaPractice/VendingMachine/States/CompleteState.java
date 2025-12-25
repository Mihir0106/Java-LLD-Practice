package JavaPractice.VendingMachine.States;

import JavaPractice.VendingMachine.Interface.IState;
import JavaPractice.VendingMachine.VendingMachine;

public class CompleteState implements IState {
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

        // Transaction Complete
        // Dispatch Product
        machine.dispatchProduct();

        machine.ChangeState(new IdleState());

    }

    @Override
    public void transactionFailed(VendingMachine machine) {
        this.machine = machine;
    }
}
