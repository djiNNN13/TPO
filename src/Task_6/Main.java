package Task_6;

import Task_6.Counter;
import Task_6.ICounter;
import Task_6.LockCounter;
import Task_6.SyncBlockCounter;
import Task_6.SyncCounter;

public class Main {
    public static void main(String[] args) {
        defaultCounter();
        synchronizedCounter();
        syncBlockCounter();
        lockCounter();
    }

    private static void defaultCounter() {
        ICounter counter = new Counter();
        runCounter(counter);
        System.out.println("Default counter:" + counter.getCounter());
    }

    private static void synchronizedCounter() {
        ICounter counter = new SyncCounter();
        runCounter(counter);

        System.out.println("Synchronized counter:" + counter.getCounter());
    }

    private static void syncBlockCounter() {
        ICounter counter = new SyncBlockCounter();
        runCounter(counter);

        System.out.println("Synchronized block counter:" + counter.getCounter());
    }

    private static void lockCounter() {
        ICounter counter = new LockCounter();
        runCounter(counter);

        System.out.println("Lock counter:" + counter.getCounter());
    }

    private static void runCounter(ICounter counter) {
        CounterThread incrementThread = new CounterThread(true, counter);
        CounterThread decrementThread = new CounterThread(false, counter);
        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (Exception e) {
        }
    }
}