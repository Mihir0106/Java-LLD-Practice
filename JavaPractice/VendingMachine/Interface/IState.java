package JavaPractice.VendingMachine.Interface;

import JavaPractice.VendingMachine.VendingMachine;

public interface IState {

    public void available(VendingMachine machine);
    public void performingTransaction(VendingMachine machine);
    public void transactionComplete(VendingMachine machine);
    public void transactionFailed(VendingMachine machine);
}
