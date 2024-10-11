package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/remove-k-digits/description/
public class RemoveKDigits {
    //remove trailing zeroes
    StringBuilder removeTrailingZeroes(StringBuilder s) {
        int i=0;
        while(i<s.length() &&  s.charAt(i)=='0') {
            i++;
        }
        s.delete(0, i);
        return s;
    }
    public String removeKdigits(String num, int k) {

        int n = num.length();

        Stack<Character> s1 = new Stack<>();

        //we have to remove k elements so be greedy and remove k elements from start
        //and remove largest k elements from start
        for(int i=0;i<n;i++) {

            //a larger element is in stack, if we remove and push smaller then the number would be smaller
            while(!s1.isEmpty() && s1.peek()>num.charAt(i) && k>0) {
                s1.pop();
                k--;
            }
            s1.push(num.charAt(i));
        }

        //if k is still left eg- "123456" and k=3 then all are inc order and all added to stack
        //so we can remove 456 so that is remove from top of stack
        while(k>0) {
            s1.pop();
            k--;
        }


        //convert stack to string
        StringBuilder removedString = new StringBuilder();
        while(!s1.isEmpty()) {
            removedString.append(s1.pop());
        }

        //remove trailing zeros
        StringBuilder s = removedString.reverse();
        StringBuilder trimmedString = removeTrailingZeroes(s);

        //if empty then return "0"
        if(trimmedString.isEmpty()) {
            return "0";
        }

        return trimmedString.toString();
    }
}
