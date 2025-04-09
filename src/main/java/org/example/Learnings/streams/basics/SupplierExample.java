package org.example.Learnings.streams.basics;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 10;
        System.out.println(supplier.get());
    }
}
