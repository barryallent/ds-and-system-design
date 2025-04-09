package org.example.Learnings.threads;

public class ThreadStates extends Thread {
    @Override
    public void run() {
        System.out.println("Thread is running");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStates thread = new ThreadStates();

        //initial state after creating the thread but not starting
        System.out.println("Thread state: " + thread.getState());
        thread.start();

        //state after starting the thread, its runnable, There is no running state in enum state
        System.out.println("Thread state: " + thread.getState());

        //this is to sleep the main class thread so the run thread goes to waiting state for 2s
        Thread.sleep(1000);
        //now the thread sleeps  for 2 seconds, so thread state becomes TIMED_WAITING
        System.out.println("Thread state: " + thread.getState());

        //join method so that main thread waits for other thread to finish
        thread.join();
        System.out.println("Thread state: " + thread.getState());
    }

}
