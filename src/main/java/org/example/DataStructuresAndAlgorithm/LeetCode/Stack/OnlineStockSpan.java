package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/online-stock-span/description/
public class OnlineStockSpan {
    //keep stack and also track totalDays
    Stack<int[]> s1;
    int totalDays;
    public OnlineStockSpan() {
        totalDays=0;
        s1 = new Stack<>();
    }

    public int next(int price) {

        //if we found that price is greater then keep popping
        while(!s1.isEmpty() && price>=s1.peek()[0]) {
            s1.pop();
        }
        int days;

        //if stack is empty then we keep as -1
        if(s1.isEmpty()) {
            days = totalDays + 1;
        }

        //total days this price is bigger = how many days it popped, and that we can get by
        //index difference of price and top of stack
        else {
            days = totalDays - s1.peek()[1];
        }

        //push the price and current day to stack
        s1.push(new int[]{price,totalDays});

        //increase total days each time
        totalDays++;
        return days;
    }
}
