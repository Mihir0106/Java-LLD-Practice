package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Interface.IState;
import JavaPractice.VendingMachine.States.IdleState;
import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.States.OngoingState;

public class VendingMachine {
    IState state;
    ProductInventoryManager productInventoryManager;
    PaymentHandlerManager paymentHandlerManager;

    int productId;
    int currentBalance;

    public VendingMachine(ProductInventoryManager productInventoryManager,
            PaymentHandlerManager paymentHandlerManager) {
        state = new IdleState();
        this.productInventoryManager = productInventoryManager;
        this.paymentHandlerManager = paymentHandlerManager;
        this.currentBalance = 0;
    }

    public void ChangeState(IState state) {
        this.state = state;
    }

    public void available() {
        state.available(this);
    }

    public void performingTransaction() {
        state.performingTransaction(this);
    }

    public void transactionComplete() {
        state.transactionComplete(this);
    }

    public void transactionFailed() {
        state.transactionFailed(this);
    }

    public void ShowProducts() {
        productInventoryManager.showProducts();
    }

    public synchronized void selectProduct(int productId) {
        this.productId = productId;
        // If in Idle, switch to Ongoing
        if (state instanceof IdleState) {
            ChangeState(new OngoingState());
        }
        // Trigger availability check immediately (in case money was already inserted)
        performingTransaction();
    }

    public synchronized void insertMoney(Currency currency) {
        this.currentBalance += currency.getValue();
        System.out.println("Inserted: " + currency.getValue() + ". Total: " + currentBalance);
        // Delegate to state to check if we can proceed
        performingTransaction();
    }

    public synchronized boolean BalanceAvailable() {
        if (productInventoryManager.getProduct(productId) == null)
            return false;
        return currentBalance >= productInventoryManager.getProduct(productId).getPrice();
    }

    public synchronized void dispatchProduct() {
        productInventoryManager.dispenseProduct(productId, 1);
        int price = productInventoryManager.getProduct(productId).getPrice();
        System.out.println("Dispensing Product: " + productId);
        System.out.println(paymentHandlerManager.calculateRefund(currentBalance, price));
        currentBalance = 0; // Reset balance after transaction
        productId = 0;
    }
}
