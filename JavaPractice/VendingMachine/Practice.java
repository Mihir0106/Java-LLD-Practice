package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.ReturnExchangeStrategies.NormalReturnStrategy;

import java.util.Scanner;

public class Practice {
    static void main() {
        ProductInventoryManager productInventoryManager = new ProductInventoryManager();
        productInventoryManager.addNewProduct("coke",10,1);
        productInventoryManager.addNewProduct("perk",7,2);

        PaymentHandlerManager paymentHandlerManager = new PaymentHandlerManager(new NormalReturnStrategy());
        paymentHandlerManager.AddCurrencyTypeQuantity(Currency.One,5);
        paymentHandlerManager.AddCurrencyTypeQuantity(Currency.Five,1);

        VendingMachine vendingMachine = new VendingMachine(productInventoryManager,paymentHandlerManager);

        vendingMachine.ShowProducts();


    }
}
