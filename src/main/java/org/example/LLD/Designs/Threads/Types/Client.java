package org.example.LLD.Designs.Threads.Types;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<String> future = executorService.submit(new MyCallable());

        System.out.println(future.get());
    }
}
