package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
public class EvaluateReversePolishNotation {
        public int evalRPN(String[] tokens) {
            Stack<Integer> s1 = new Stack<>();

            int answer = 0;

            for (String s : tokens) {

                if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                    int operand1 = !s1.isEmpty() ? s1.pop() : 0;
                    int operand2 = !s1.isEmpty() ? s1.pop() : 0;
                    if (s.equals("+")) {
                        answer = (operand1 + operand2);
                    } else if (s.equals("-")) {
                        answer = (operand2 - operand1);
                    } else if (s.equals("*")) {
                        answer = (operand2 * operand1);
                    } else if (s.equals("/")) {
                        answer = (operand2 / operand1);
                    }
                    s1.add(answer);
                } else {
                    s1.add(Integer.valueOf(s));
                }
            }
            return s1.isEmpty() ? answer : s1.pop();
        }

}
