package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.ReturnExchangeStrategies.NormalReturnStrategy;

import java.util.Scanner;

public class Practice {
    public static void main(String[] args) {
        ProductInventoryManager productInventoryManager = new ProductInventoryManager();
        productInventoryManager.addNewProduct("coke", 10, 1);
        productInventoryManager.addNewProduct("perk", 7, 2);

        PaymentHandlerManager paymentHandlerManager = new PaymentHandlerManager(new NormalReturnStrategy());
        paymentHandlerManager.AddCurrencyTypeQuantity(Currency.One, 5);
        paymentHandlerManager.AddCurrencyTypeQuantity(Currency.Five, 1);

        VendingMachine vendingMachine = new VendingMachine(productInventoryManager, paymentHandlerManager);

        System.out.println("--- Vending Machine Started ---");
        vendingMachine.ShowProducts();

        System.out.println("\n--- User Inserts Money ---");
        vendingMachine.insertMoney(Currency.Ten);

        System.out.println("\n--- User Selects Product (Coke @ 10) ---");
        // Coke ID is 1 (based on increment logic in ProductInventoryManager)
        vendingMachine.selectProduct(1);

        System.out.println("\n--- Next Transaction: Not enough money ---");
        vendingMachine.selectProduct(2); // Perk @ 7. Balance is 0 now.
        vendingMachine.insertMoney(Currency.Five); // Total 5. Price 7.
        // Should wait.
        System.out.println("Inserting 2 more...");
        vendingMachine.insertMoney(Currency.One);
        vendingMachine.insertMoney(Currency.One);
        // Total 7. Should dispense.

    }
}
