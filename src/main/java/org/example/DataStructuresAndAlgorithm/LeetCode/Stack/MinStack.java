package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

public class MinStack {

    Stack<int[]> s1;
    int minOfStack;

    public MinStack() {
        s1 = new Stack<>();
        minOfStack=Integer.MAX_VALUE;
    }

    public void push(int val) {
        minOfStack=Math.min(minOfStack,val);
        s1.add(new int[]{val,minOfStack});
    }

    public void pop() {
        s1.pop();
        minOfStack= !s1.isEmpty() ? s1.peek()[1] : Integer.MAX_VALUE;
    }

    public int top() {
        return s1.peek()[0];
    }

    public int getMin() {
        return s1.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
