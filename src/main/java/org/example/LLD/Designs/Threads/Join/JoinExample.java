package org.example.LLD.Designs.Threads.Join;

import org.example.LLD.Designs.Threads.Join.MyThread;

public class JoinExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();

        try {
            t1.join();  // The main thread waits for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("t1 has finished, main thread continues");

        try {
            t2.join();  // The main thread waits for t2 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("t2 has finished, main thread continues");

    }
}
