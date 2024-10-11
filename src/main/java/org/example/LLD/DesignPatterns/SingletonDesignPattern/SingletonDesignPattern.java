package org.example.LLD.DesignPatterns.SingletonDesignPattern;

public class SingletonDesignPattern {
    public static SingletonDesignPattern singletonDesignPattern;

    private SingletonDesignPattern() {
        // Simulate some initialization work
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static SingletonDesignPattern getSingletonDesignPattern() {
        synchronized (SingletonDesignPattern.class) {
            if (singletonDesignPattern == null) {
                //this will call the constructor and there is a delay there that means another thread can come at same time
                //and singletonDesignPattern would still be null so that thread will also create the object
                //but we have used synchronized block so this section of code will be called by only thread at a time
                singletonDesignPattern = new SingletonDesignPattern();
            }
        }

        return singletonDesignPattern;
    }
}

class WorkerClass {

    public static void main(String[] args) {
        Runnable task = () -> {
            SingletonDesignPattern instance = SingletonDesignPattern.getSingletonDesignPattern();
            System.out.println(Thread.currentThread().getName() + " - " + instance.hashCode());
        };

        // Create and start multiple threads
        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        // Wait for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
