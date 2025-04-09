package org.example.Learnings.streams.start;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LazyEvaluationDemo {
    public static void main(String[] args) {
        List<String> names = List.of("Sam", "John", "Peter", "Sara", "Jane");
        Stream<String> namesStream = names.stream().filter(name -> {
            System.out.println("Filtering " + name);
            return name.length() == 3;
        });

        //Filtering will not print
        System.out.println("Before terminal operation");

        List<String> result = namesStream.collect(Collectors.toList());
        System.out.println("After terminal operation");
        System.out.println(result);

    }
}
