package org.example.Learnings.streams.start;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {
          //Terminal Operations
        //1. forEach: It is used to iterate over each element of the stream.
        //2. collect: It is used to collect elements of the stream into a collection.
        //3. count: It is used to count the number of elements in the stream.
        //5. reduce: It is used to reduce the elements of the stream to a single value.
        //6. findFirst: It is used to find the first element of the stream.
        //7. findAny: It is used to find any element of the stream.
        //8. toArray: It is used to convert the stream into an array.
        //9. min: It is used to find the minimum element of the stream.
        //10. max: It is used to find the maximum element of the stream.
        //11. anyMatch: It is used to check if any element of the stream matches the given predicate.
        //12. noneMatch: It is used to check if none of the elements of the stream matches the given predicate.
        //13. allMatch: It is used to check if all the elements of the stream match the given predicate.
        //14. sum: It is used to find the sum of the elements of the stream.
        //15. average: It is used to find the average of the elements of the stream.
        //16. summaryStatistics: It is used to get the summary statistics of the elements of the stream.
        //17. groupingBy: It is used to group the elements of the stream based on a classifier function.
        //18. partitioningBy: It is used to partition the elements of the stream based on a predicate.
        //19. joining: It is used to join the elements of the stream into a single string.
        //20. counting: It is used to count the number of elements in the stream.
        //21. mapping: It is used to map the elements of the stream to another type.
        //22. flatMapping: It is used to map the elements of the stream to a stream of values and then flatten the resulting streams into a single stream.
        //23. reducing: It is used to reduce the elements of the stream to a single value using an associative accumulation function and an identity value.
        //24. collectingAndThen: It is used to perform an additional finishing transformation on the result of a collector.
        //25. toList: It is used to collect the elements of the stream into a List.
        //26. toSet: It is used to collect the elements of the stream into a Set.
        //27. toMap: It is used to collect the elements of the stream into a Map.
        //28. toCollection: It is used to collect the elements of the stream into a Collection.
        //29. toConcurrentMap: It is used to collect the elements of the stream into a ConcurrentMap.
        //30. toUnmodifiableList: It is used to collect the elements of the stream into an unmodifiable List.


        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //1. For each
        numbers.stream().skip(4).forEach(System.out::println);


        //2. Collect
        numbers.stream().skip(5).collect(Collectors.toList()).forEach(System.out::println);
        numbers.stream().skip(6).collect(Collectors.toSet()).forEach(System.out::println);

        //3. Count
        numbers.stream().skip(7).count();

        //5. reduce, combines elements of stream into single value, basically its giving sum of all elements here
        Optional<Integer> number = numbers.stream().skip(6).reduce((a, b)->a+b);
        //Optional - A container object which may or may not contain a non-null value.
        System.out.println(number.get());


        //6. findFirst, returns first element of stream
        //returns optional so we can do get
        System.out.println(numbers.stream().findFirst());
        System.out.println(numbers.stream().findFirst().get() );

        //7. findAny, returns any element of stream
        System.out.println(numbers.stream().findAny().get());

        //8. anyMatch, allMatch, noneMatch
        boolean a = numbers.stream().anyMatch(x->x%2==0);
        boolean b = numbers.stream().allMatch(x->x>0);
        boolean c = numbers.stream().noneMatch(x->x<0);
        System.out.println(a+" "+b+" "+c);

        // all these findFirst, findAny, anyMatch, allMatch, noneMatch are short circuit operations,
        //  means they will not process all elements of stream, they will stop as soon as they find the result


        //Example: filtering and collecting names
        List<String> names = List.of("Johnathhan", "Jan", "Adam", "Tom", "John", "Janet","John");
        System.out.println(names.stream().filter(z->z.length()>3).collect(Collectors.toList()));

        //Example: Square and sorting numbers
        List<Integer> numbers2 = List.of(4, 2, 1, -5, 8, -6);
        System.out.println(numbers2.stream().map(x->x*x).sorted().collect(Collectors.toList()));

        //Example : sum of list
        List<Integer> numbers3 = Arrays.asList(1,5,4,3);
        System.out.println(numbers3.stream().reduce((x,y)-> x+y).get());

        //Example: Count occurance of a character in a string
        //someString.chars() - returns IntStream
        String someString = "hello world";
        System.out.println(someString.chars().filter(x->x=='l').count());

        //Streams cannot be reused after a terminal operation is used.

        //9. min/max
        System.out.println(numbers);
        int minimum = numbers.stream().min((p,q)->p-q).get();
        System.out.println(numbers.stream().min((p,q)->p-q).get());
        System.out.println(numbers.stream().max((p,q)->p-q).get());
    }
}
