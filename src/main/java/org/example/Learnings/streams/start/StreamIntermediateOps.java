package org.example.Learnings.streams.start;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations, transforms one stream to other stream
        // Intermediate operations are lazy, they are not executed until a terminal operation is invoked
        // filter() - returns a stream consisting of elements that match the given predicate
        // map() - returns a stream consisting of the results of applying the given function to the elements of this stream
        // flatMap() - returns a stream consisting of the results of replacing each element of this stream with the contents of a mapped stream produced by applying the provided mapping function to each element
        // distinct() - returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream
        // sorted() - returns a stream consisting of the elements of this stream, sorted according to natural order
        // peek() - returns a stream consisting of the elements of this stream, additionally performing the provided action on each element as elements are consumed from the resulting stream
        // limit() - returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length
        // skip() - returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream

        List<String> names = Arrays.asList("Johnathhan", "Jan", "Adam", "Tom", "John", "Janet","John");

        //1. filter, does sum filtering, accepts a predicate, that means does filtering based on some condition
        Stream<String> filteredNames = names.stream().filter(x->x.startsWith("J"));

        System.out.println(filteredNames.count());

        System.out.println("*****************************************************");

        //2. map, does some transformation, accepts a function, that means does some transformation on each element
        names.stream().map(x->x.toUpperCase()).collect(Collectors.toList()).forEach(x-> System.out.println(x));
        System.out.println("*****************************************************");

        //3. Sorted List
        names.stream().sorted().collect(Collectors.toList()).forEach(x-> System.out.println(x));
        System.out.println("*****************************************************");

        //sorting based on custom comparator
        names.stream().sorted((a,b)-> a.length()-b.length()).collect(Collectors.toList()).forEach(x-> System.out.println(x));
        System.out.println("*****************************************************");

        //4. distinct, gives distinct elements
        names.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*****************************************************");

        //5. limit, gives only first n elements
        System.out.println(Stream.iterate(1, x->x+1).limit(25).count());

        //6. skip, skips first n elements
        System.out.println(Stream.iterate(1, x->x+1).skip(15).limit(25).collect(Collectors.toList()));

        //9. peek - used for debugging, it is intermediate operation
        Stream.iterate(1,x->x+1).limit(10).peek(System.out::println).count();

        //10. flatmap - used to flatten the stream of streams
        List<List<String>> fruitsList = Arrays.asList(
                Arrays.asList("Apple", "Banana"),
                Arrays.asList("Orange", "Grapes"),
                Arrays.asList("Watermelon", "Pineapple")
        );

        //converts the above list of list in single list, flatMap says that it gets list and it converts it into single stream
        System.out.println(fruitsList.stream().flatMap(y-> y.stream()).toList());

        List<String> sentenses = Arrays.asList("Hello World", "This is Java", "I am learning streams");
        System.out.println(sentenses.stream().flatMap(x->Arrays.stream(x.split(" "))).toList());


    }

}
