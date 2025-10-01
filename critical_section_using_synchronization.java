class Counter {
    private int count = 0;

    // Synchronized method to ensure thread safety in critical section
    public synchronized void increment() {
        count++;  // Critical section
    }

    public int getCount() {
        return count;
    }
}

class MyThread extends Thread {
    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();  // Accessing the critical section
        }
    }
}

public class CriticalSectionExample {
    public static void main(String[] args) {
        Counter counter = new Counter();

        // Create multiple threads to test critical section handling
        Thread t1 = new MyThread(counter);
        Thread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        // Wait for both threads to finish execution
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // The count should be 2000 as both threads increment it 1000 times
        System.out.println("Final count: " + counter.getCount());
    }
}
