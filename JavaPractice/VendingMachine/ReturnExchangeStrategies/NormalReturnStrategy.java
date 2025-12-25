package JavaPractice.VendingMachine.ReturnExchangeStrategies;

import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.Enums.TransactionState;
import JavaPractice.VendingMachine.Interface.IReturnExchangeStrategy;

import java.util.*;

public class NormalReturnStrategy implements IReturnExchangeStrategy {
    HashMap<Currency,Integer> returnCurrency;

    public NormalReturnStrategy(){
        returnCurrency = new HashMap<>();
    }

    @Override
    public String Return(int userPaid, int productPrice) {
        if(userPaid == productPrice) return TransactionState.NoReturnRequired.toString();
        else if(userPaid < productPrice){
            return TransactionState.NOTEnoughMoney.toString();
        }
        else {
            return TransactionState.ReturnRequired + "\n" + ConvertInString(CalculateReturn(userPaid - productPrice));
        }
    }

     HashMap<Currency,Integer> CalculateReturn(int amount){

        Currency[] currencyTypes = Currency.values();
        Arrays.sort(currencyTypes,(a,b) -> b.getValue() - a.getValue());

        for(Currency currency : currencyTypes) {
            int count = 0;
            int currencyAmount = currency.getValue();
            if(amount > currencyAmount){
                count = amount/currencyAmount;
                amount = amount%currencyAmount;
                returnCurrency.put(currency,count);
            }
        }
        return returnCurrency;
    }

    String ConvertInString(HashMap<Currency,Integer> returnCurrency){
        StringBuilder returnAmount = new StringBuilder();
        for(Map.Entry<Currency,Integer> entry : returnCurrency.entrySet()){
            returnAmount.append(entry.getKey()).
                    append(" currency with ").
                    append(entry.getValue()).
                    append(" quantity \n");
        }

        return returnAmount.toString();
    }

}



