package org.example.Learnings.streams.basics;

import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        //hold contitions
        Predicate<Integer> isEven = x -> x%2==0;

        System.out.println(isEven.test(4));


        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        //check if list is empty
        Predicate<List<Integer>> isEmpty = x -> x.size()==0;

        System.out.println(isEmpty.test(numbers));

    }
}
