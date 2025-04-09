package org.example.Learnings.streams.basics;

public class Lambda {

    public static void main(String[] args) {

        //basically we are holding the function in a variable instead of implementing the method in a class
        MathOperation sumOperation = (a, b) -> a + b;
        System.out.println(sumOperation.operate(10, 20));
    }
}


interface MathOperation {
    int operate(int a, int b);
}
