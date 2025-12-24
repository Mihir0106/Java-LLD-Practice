package JavaPractice.ParkingLotSystem;

import JavaPractice.ParkingLotSystem.Entity.ParkingSpot;
import JavaPractice.ParkingLotSystem.Entity.User;
import JavaPractice.ParkingLotSystem.Entity.Vehicle;
import JavaPractice.ParkingLotSystem.Enum.VehicleType;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingService;
import JavaPractice.ParkingLotSystem.Interfaces.IParkingStrategy;
import JavaPractice.ParkingLotSystem.Manager.LevelManager;
import JavaPractice.ParkingLotSystem.Manager.ParkingLotManager;
import JavaPractice.ParkingLotSystem.ParkingStrategies.NormalParkingStrategy;
import JavaPractice.ParkingLotSystem.Services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Starting Concurrency Stress Test ===");

        // 1. Setup: 1 Level with only 5 Spots
        int totalSpots = 5;
        ParkingLotManager parkingLotManager = getParkingLotManager(totalSpots);
        IParkingService parkingService = new ParkingLotService(parkingLotManager);

        // 2. Configuration for Contention
        int numberOfThreads = 20; // 20 cars trying to park in 5 spots
        ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(numberOfThreads);
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failureCount = new AtomicInteger(0);
        AtomicInteger exceptionCount = new AtomicInteger(0);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            users.add(new User(i, "User" + i, new Vehicle(VehicleType.Car, 1000 + i, "Car" + i)));
        }

        // 3. Run Threads
        System.out.println("Spawning " + numberOfThreads + " threads competing for " + totalSpots + " spots...");

        for (User user : users) {
            executor.submit(() -> {
                try {
                    startLatch.await(); // Wait for signal
                    parkingService.ParkVehicle(user);

                    // We can't easily check boolean return since ParkVehicle is void,
                    // but we can assume success if no exception was thrown and check internals
                    // later?
                    // Actually, the current ParkVehicle implementation prints "parking spot Not
                    // available" but doesn't throw specific exception unless it was the NPE one.
                    // Let's rely on the check below.
                    successCount.incrementAndGet();

                } catch (Exception e) {
                    // System.out.println("Exception: " + e.getMessage());
                    exceptionCount.incrementAndGet();
                    failureCount.incrementAndGet();
                } finally {
                    doneLatch.countDown();
                }
            });
        }

        startLatch.countDown(); // Go!
        doneLatch.await(5, TimeUnit.SECONDS);
        executor.shutdown();

        // 4. Verification
        System.out.println("\n=== Results ===");
        System.out.println("Total Requests: " + numberOfThreads);
        System.out.println("Total Spots Available: " + totalSpots);
        // Note: ParkVehicle logic swallows "Not Available" and just prints.
        // We need to inspect the ACTUAL number of spots filled.

        // Inspect internal state (Hack for test verification)
        // Ideally we would add a method to get occupied count.
        // But let's check basic sanity.

        System.out.println("Reported 'Success' attempts (no crash): " + successCount.get());
        System.out.println("Reported Exceptions: " + exceptionCount.get());

        System.out.println("\n[Analysis requires checking logs for 'parking spot Not available']");
        System.out.println(
                "If Thread Safety is broken, we might see ConcurrentModificationExceptions or corrupted states.");
    }

    private static ParkingLotManager getParkingLotManager(int spots) {
        LevelManager levelManager = new LevelManager();
        // Add all spots as CAR spots
        for (int i = 0; i < spots; i++) {
            levelManager.AddParkingSpot(new ParkingSpot(VehicleType.Car));
        }

        IParkingStrategy parkingStrategy = new NormalParkingStrategy();
        ParkingLotManager parkingLotManager = new ParkingLotManager(parkingStrategy);
        parkingLotManager.addLevel(levelManager);
        return parkingLotManager;
    }
}
