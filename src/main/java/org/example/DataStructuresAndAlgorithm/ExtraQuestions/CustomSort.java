package org.example.DataStructuresAndAlgorithm.ExtraQuestions;

import java.util.*;

public class CustomSort {
    // Comparator function for custom sorting rules
    public static int customCompare(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int minLength = Math.min(n1, n2);

        for (int i = 0; i < minLength; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            // Check if both are alphabets
            if (Character.isLetter(c1) && Character.isLetter(c2)) {
                // Capital letters come before small letters
                if (Character.isUpperCase(c1) && Character.isLowerCase(c2)) {
                    return -1;
                } else if (Character.isLowerCase(c1) && Character.isUpperCase(c2)) {
                    return 1;
                } else {
                    // Normal lexicographical comparison for same case alphabets
                    if (c1 != c2) {
                        return c1 - c2;
                    }
                }
            }
            // One is an alphabet, the other is a digit
            else if (Character.isLetter(c1) && Character.isDigit(c2)) {
                return -1; // Alphabet comes before digits
            } else if (Character.isDigit(c1) && Character.isLetter(c2)) {
                return 1; // Digits come after alphabets
            }
            // Both are digits, compare their numeric values
            else if (Character.isDigit(c1) && Character.isDigit(c2)) {
                if (c1 != c2) {
                    return c1 - c2; // Numerically compare the digits
                }
            }
        }

        // If one string is a prefix of the other, the shorter one comes first
        return n1 - n2;
    }

    public static void customSort(List<String> list) {
        // Sort list using the custom comparator
        Collections.sort(list, CustomSort::customCompare);
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("a1", "A1", "b2", "B2", "c3", "C3", "1a", "2B", "1A", "Zebra", "zebra");

        System.out.println("Original List:");
        System.out.println(input);

        customSort(input);

        System.out.println("Sorted List:");
        System.out.println(input);
    }
}

