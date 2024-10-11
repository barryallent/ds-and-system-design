package org.example.LLD.Designs.Threads.Join;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(1000);  // Simulating work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

