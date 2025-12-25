package JavaPractice.VendingMachine;

import JavaPractice.VendingMachine.Enums.Currency;
import JavaPractice.VendingMachine.ReturnExchangeStrategies.NormalReturnStrategy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrencyTest {
    public static void main(String[] args) throws InterruptedException {
        // Setup
        ProductInventoryManager inventory = new ProductInventoryManager();
        inventory.addNewProduct("Coke", 10, 1); // Only 1 Coke available

        PaymentHandlerManager payment = new PaymentHandlerManager(new NormalReturnStrategy());
        payment.AddCurrencyTypeQuantity(Currency.One, 100);

        VendingMachine vm = new VendingMachine(inventory, payment);

        System.out.println("Starting Concurrency Test...");
        System.out.println("Initial Stock: 1 Coke. 2 Threads trying to buy it simultaneously.");

        // Runnable task for a user trying to buy Coke
        Runnable userTask = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println(threadName + ": Inserting Money...");
                vm.insertMoney(Currency.Ten);

                System.out.println(threadName + ": Selecting Product...");
                vm.selectProduct(1);

                System.out.println(threadName + ": Finished sequence.");
            } catch (Exception e) {
                System.out.println(threadName + " Error: " + e.getMessage());
            }
        };

        // Create 2 threads
        Thread t1 = new Thread(userTask, "User-1");
        Thread t2 = new Thread(userTask, "User-2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nTest Completed.");
        // Check remaining stock - should be 0, not -1
        // Since we can't easily peek inside without getter, we rely on output for now
        // But logic dictates one should fail.
    }
}
