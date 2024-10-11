package org.example.LLD.Designs.Threads.Types;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("i am callable");
        return "called";
    }
}
