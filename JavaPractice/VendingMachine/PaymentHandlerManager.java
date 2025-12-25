package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.Enums.TransactionState;
import JavaPractice.VendingMachine.Interface.ICollectMoney;
import JavaPractice.VendingMachine.Interface.IReturnExchangeStrategy;

import java.util.HashMap;
import java.util.Map;

public class PaymentHandlerManager implements ICollectMoney {

    IReturnExchangeStrategy returnExchangeStrategy;
    Map<Currency,Integer> BalanceStatus;

    public PaymentHandlerManager(IReturnExchangeStrategy returnExchangeStrategy){
        this.returnExchangeStrategy = returnExchangeStrategy;
        BalanceStatus = new HashMap<>();
    }

    public String calculateRefund(int userPaid, int productPrice){
        return returnExchangeStrategy.Return(userPaid,productPrice);
    }


    @Override
    public synchronized void AddCurrencyTypeQuantity(Currency currency, int count) {
        BalanceStatus.put(currency, BalanceStatus.getOrDefault(currency,0) + count);
    }

    @Override
    public Integer collectCurrencyTypeQuantity(Currency currency) {
        int count = BalanceStatus.get(currency);
        BalanceStatus.put(currency,0);
        return count;
    }
}
