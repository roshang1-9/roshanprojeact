import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Demonstrates basic multithreading concepts in Java:
 * - Creating threads by extending Thread and by implementing Runnable
 * - Using ExecutorService (thread pool)
 * - Race condition on a shared counter and fixes using synchronized and AtomicInteger
 * - Thread.sleep, join, and interruption handling
 */
public class MultithreadingDemo {

    // 1) Thread by extending Thread
    static class CountingThread extends Thread {
        private final int id;

        public CountingThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.printf("[CountingThread-%d] %d\n", id, i);
                try {
                    Thread.sleep(100); // pause to allow interleaving
                } catch (InterruptedException e) {
                    System.out.println("[CountingThread] interrupted");
                    return;
                }
            }
        }
    }

    // 2) Runnable implementation
    static class MessagePrinter implements Runnable {
        private final String message;

        public MessagePrinter(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("[MessagePrinter] " + message + " (" + (i+1) + ")");
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    System.out.println("[MessagePrinter] interrupted");
                    return;
                }
            }
        }
    }

    // 3) Shared counter to show race condition
    static class SharedCounter {
        public int value = 0;

        public void increment() {
            value = value + 1; // not atomic
        }

        // synchronized increment
        public synchronized void incrementSync() {
            value = value + 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Multithreading demo ---\n");

        // Example A: start threads directly
        CountingThread t1 = new CountingThread(1);
        CountingThread t2 = new CountingThread(2);
        t1.start();
        t2.start();

        // Wait for them to finish
        t1.join();
        t2.join();

        System.out.println("\n--- Runnable + ExecutorService demo ---");

        // Example B: using Runnable and ExecutorService (thread pool)
        ExecutorService pool = Executors.newFixedThreadPool(3);
        pool.submit(new MessagePrinter("Hello from A"));
        pool.submit(new MessagePrinter("Hello from B"));
        pool.submit(new MessagePrinter("Hello from C"));

        // shutdown and wait
        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("\n--- Race condition demonstration ---");

        // Example C: race condition on shared counter
        SharedCounter counter = new SharedCounter();
        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread w = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.increment(); // not synchronized
                }
            });
            workers.add(w);
            w.start();
        }
        for (Thread w : workers) w.join();
        System.out.println("Expected counter value = 100 * 1000 = 100000");
        System.out.println("Actual (race) counter value = " + counter.value);

        // Fix using synchronized method
        counter = new SharedCounter();
        workers.clear();
        for (int i = 0; i < 100; i++) {
            Thread w = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementSync();
                }
            });
            workers.add(w);
            w.start();
        }
        for (Thread w : workers) w.join();
        System.out.println("After synchronized increments, counter value = " + counter.value);

        // Fix using AtomicInteger
        System.out.println("\n--- AtomicInteger demonstration ---");
        java.util.concurrent.atomic.AtomicInteger atomic = new AtomicInteger(0);
        workers.clear();
        for (int i = 0; i < 100; i++) {
            Thread w = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    atomic.incrementAndGet();
                }
            });
            workers.add(w);
            w.start();
        }
        for (Thread w : workers) w.join();
        System.out.println("AtomicInteger value = " + atomic.get());

        System.out.println("\n--- Interrupted thread example ---");
        Thread sleepy = new Thread(() -> {
            try {
                System.out.println("Sleepy thread going to sleep for 5s...");
                Thread.sleep(5000);
                System.out.println("Sleepy thread woke normally");
            } catch (InterruptedException e) {
                System.out.println("Sleepy thread was interrupted during sleep");
            }
        });
        sleepy.start();
        // interrupt it after 500ms
        Thread.sleep(500);
        sleepy.interrupt();
        sleepy.join();

        System.out.println("\n--- Demo complete ---");
    }
}
