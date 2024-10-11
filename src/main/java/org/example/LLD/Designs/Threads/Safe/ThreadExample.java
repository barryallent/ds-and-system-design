package org.example.LLD.Designs.Threads.Safe;

public class ThreadExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadSafe counter = new ThreadSafe();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        //always print 2000, if we dont use syncronized then mostly print less than 1000
        System.out.println("Count: " + counter.getCount());
    }
}
