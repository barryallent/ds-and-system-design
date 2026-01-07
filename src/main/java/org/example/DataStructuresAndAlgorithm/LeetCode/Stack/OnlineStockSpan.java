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

//class StockSpanner {
//
//    //monotonic decreasing stack because we want to pop smaller as soon as greater values come
//    //to check how many values it is greater with
//    Stack<int[]> s1;
//    List<Integer> prices;
//
//    public StockSpanner() {
//        s1 = new Stack<>();
//        prices = new ArrayList<>();
//    }
//
//    public int next(int price) {
//
//        //count number of days current price is greater
//        int days=1;
//
//        //there is no for loop so this how we get index, for 1st element the size will be 0 so index=0
//        int index=prices.size();
//
//        //keep popping smaller days
//        while(!s1.isEmpty() && price>=s1.peek()[0]) {
//            int[] topElement = s1.pop();
//
//            //update index to the one we popped because if new elements come
//            //then it will know that this element has removed index till here, so if someone is greater
//            //than this element so they would have also removed elements before this one
//            index=topElement[1];
//
//            //calulation of days its greater, so that will be current index - the one we have popped
//            //adding one because it expects to be 1 day when no price is greater
//            days=Math.max(days,prices.size()-topElement[1]+1);
//        }
//
//        //after popping all smaller add this to stack with the index
//        s1.add(new int[]{price,index});
//
//        //add to array and return the days
//        prices.add(price);
//        return days;
//    }
//}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */