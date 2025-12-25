package JavaPractice.VendingMachine.Interface;

import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.Enums.TransactionState;

import java.util.HashMap;

public interface IReturnExchangeStrategy {

    public String Return(int userPaid, int ProductPrice);

}
