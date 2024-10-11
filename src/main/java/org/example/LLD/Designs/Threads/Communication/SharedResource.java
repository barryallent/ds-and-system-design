package org.example.LLD.Designs.Threads.Communication;

public class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized void put(int value) throws InterruptedException {
        while (available) {
            wait();
        }
        data = value;
        available = true;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        while (!available) {
            wait();
        }
        available = false;
        notifyAll();
        return data;
    }
}