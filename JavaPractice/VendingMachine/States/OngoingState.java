package JavaPractice.VendingMachine.States;

import JavaPractice.VendingMachine.Interface.IState;
import JavaPractice.VendingMachine.VendingMachine;

public class OngoingState implements IState {
    VendingMachine machine;

    @Override
    public void available(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void performingTransaction(VendingMachine machine) {
        this.machine = machine;
        // Check Amount is Enough for Transaction
        if(machine.BalanceAvailable()){
            machine.ChangeState(new CompleteState());
            machine.transactionComplete();
        }

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
