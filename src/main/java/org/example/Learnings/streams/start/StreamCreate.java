package org.example.Learnings.streams.start;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreate {


    public static void main(String[] args) {
        //feature introduced in java8

        //process collections of data in functional and declarative way

        //how to use streams?
        //1. create a stream
        //2. define intermediate operations
        //3. define terminal operations

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //lets say we have to count even numbers in this, so we can do this in one line using streams

        long evenCount = numbers.stream().filter(x->x%2==0).count();
        System.out.println(evenCount);


        //Creating streams, few methods
        //1. From collections
        List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream1 = numbers.stream();

        //2. From arrays
        Integer[] arr = {1, 2, 3, 4, 5};
        Stream<Integer> stream2 = Arrays.stream(arr);

        //3. Using stream.of
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        //4. Infinite streams, can limit the size also using limit
         Stream<Integer> stream4 = Stream.generate(()->1).limit(100);
         Stream<Integer> stream5 = Stream.iterate(1, x->x+1).limit(100);
    }

}
