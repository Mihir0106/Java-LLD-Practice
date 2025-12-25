package JavaPractice.VendingMachine.Interface;

import JavaPractice.VendingMachine.Enums.Currency;

public interface ICollectMoney {

    public void AddCurrencyTypeQuantity(Currency currency, int count);

    public Integer collectCurrencyTypeQuantity(Currency currency);
}
