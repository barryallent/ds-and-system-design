package org.example.Learnings.streams.basics;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer,String> doubleIt = a -> {
            if(a%2==0) {
                return "good";
            }
            else {
                return "bad";
            }
        };

        String ans = doubleIt.apply(4);
        System.out.println(ans);

    }
}
