package org.example.Learnings.streams.start;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        // A type of steam that can be used to process elements in parallel
        //Allowing multiple threads to process the elements
        //This can significantly improve the performance for large datasets as workload is distributed among multiple threads
        //The parallel stream is a wrapper around the normal stream
        //It is created by calling the parallelStream() method on a collection

        List<Integer> bigList = Stream.iterate(1,x->x+1).limit(500000).toList();

        //This is sequential method, takes 95 seconds
        long start = System.currentTimeMillis();

        List<Long> factorialList = bigList.stream().map(x->getFactorial(x)).toList();

        long end = System.currentTimeMillis();

        System.out.println("Time taken for sequential stream in seconds: "+(end-start)/1000);


        //This is parallel method, takes 8 second
        start = System.currentTimeMillis();

        List<Long> factorialList2 = bigList.parallelStream().map(x->getFactorial(x)).toList();

        end = System.currentTimeMillis();

        System.out.println("Time taken for parallel stream in seconds: "+(end-start)/1000);

        //Parallel streams are most effective for CPU intensive or large datasets or where tasks are independent
        //Example: In above example, calculating the factorial is independent of each other


    }

    private static long getFactorial(int number) {
        long fact = 1;
        for(int i=1;i<=number;i++) {
            fact = fact*i;
        }
        return fact;
    }
}
