package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Interface.IState;
import JavaPractice.VendingMachine.States.IdleState;

public class VendingMachine {
    IState state;
    ProductInventoryManager productInventoryManager;
    PaymentHandlerManager paymentHandlerManager;

    int productId;

    public VendingMachine(ProductInventoryManager productInventoryManager, PaymentHandlerManager paymentHandlerManager){
        state = new IdleState();
        this.productInventoryManager = productInventoryManager;
        this.paymentHandlerManager = paymentHandlerManager;
    }

    public void ChangeState(IState state){
        this.state = state;
    }

    public void available(){
        state.available(this);
    }

    public void performingTransaction(){
        state.performingTransaction(this);
    }

    public void transactionComplete(){
        state.transactionComplete(this);
    }

    public void transactionFailed(){
        state.transactionFailed(this);
    }

    public void ShowProducts(){
        productInventoryManager.showProducts();
    }


    public boolean BalanceAvailable(){
        return false;
    }

    public void dispatchProduct(){

    }


}
