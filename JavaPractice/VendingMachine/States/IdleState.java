package JavaPractice.VendingMachine.States;

import JavaPractice.VendingMachine.Interface.IState;
import JavaPractice.VendingMachine.VendingMachine;

public class IdleState implements IState {
    VendingMachine machine;

    @Override
    public void available(VendingMachine machine) {
        this.machine = machine;

        // show Products
        machine.ShowProducts();

    }

    @Override
    public void performingTransaction(VendingMachine machine) {
        this.machine = machine;
        System.out.println("");
    }

    @Override
    public void transactionComplete(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void transactionFailed(VendingMachine machine) {
        this.machine = machine;
    }
}