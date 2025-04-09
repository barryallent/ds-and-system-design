package org.example.Learnings.threads;

public class ThreadMethods extends Thread{


    //constructor to set the name of the thread
    ThreadMethods(String name) {
        super(name);
    }

    @Override
    public void run() {

        //4. Thread priority method
        System.out.println(Thread.currentThread().getName()+" has priority:" + Thread.currentThread().getPriority());
        try {
            //2. Sleep method
            if(Thread.currentThread().getName().equals("Slow Thread"))
                Thread.sleep(5000);
            else if(Thread.currentThread().getName().equals("Medium Thread"))
                Thread.sleep(2000);
            else
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" has finished");
    }
    public static void main(String[] args) throws InterruptedException {

        ThreadMethods t1 = new ThreadMethods("Starting Thread");

        //5. Thread priority method, this can accept any integer value between 1 to 10
        t1.setPriority(Thread.MIN_PRIORITY);

        //1. Start method
        t1.start();

        //3. join method to join this thread with current thread
        t1.join();

        //this will print only after 5 seconds, when the thread finishes
        System.out.println("Thread state: " + t1.getState());

        ThreadMethods a1 = new ThreadMethods("Fast Thread");
        ThreadMethods a2 = new ThreadMethods("Medium Thread");
        ThreadMethods a3 = new ThreadMethods("Slow Thread");

        //This priority is not very strict, actually some thread with low priority can also finish earlier
        a1.setPriority(Thread.MAX_PRIORITY);
        a2.setPriority(Thread.NORM_PRIORITY);
        a3.setPriority(Thread.MIN_PRIORITY);

        a1.start();
        a2.start();
        a3.start();

        //Joined a1 thread with main thread so its state will be terminated
        a1.join();
        System.out.println(a1.getName() + " has state: " + a1.getState());

        //a2 is not joined so it will be waiting
        System.out.println(a2.getName() + " has state: " + a2.getState());

        //Joined a3 so it will be terminated
        a3.join();
        System.out.println(a3.getName() + " has state: " + a3.getState());


        //6. Thread interrupt method, will throw exception
//        ThreadMethods t2 = new ThreadMethods("Interrupted Thread");
//        t2.start();
//        t2.interrupt();

        //7. Thread isAlive method
//        System.out.println("Is t2 alive: " + t2.isAlive());

        //8. Yield method
        //This will make a thread to leave the CPU and give chance to other threads

        // Daemon thread are low priority threads that run in background and are used for garbage collection
        // JVM does not wait for daemon threads to finish before exiting

        //9. Daemon thread
        //JVM will exit when all other threads are finished, even when daemon thread is not finished
        //so "Daemon Thread has finished" will not print

        //JVM waits for user threads only
        ThreadMethods t3 = new ThreadMethods("Daemon Thread");
        t3.setDaemon(true);
        t3.start();
        System.out.println("Daemon thread state: " + t3.getState());

    }
}
