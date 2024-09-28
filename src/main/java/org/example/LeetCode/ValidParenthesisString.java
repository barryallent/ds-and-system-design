package org.example.LeetCode;

import java.util.*;

//https://leetcode.com/problems/valid-parenthesis-string/description/
public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        // openCount keeps track of the possible number of open parentheses
        // closeCount keeps track of the possible number of close parentheses
        int openCount = 0;
        int closeCount = 0;

        // Get the length of the string
        int n = s.length();

        // Iterate over the string and process both from left to right (for open parentheses)
        // and right to left (for close parentheses) at the same time
        for (int i = 0; i < n; i++) {

            // Increment openCount for '(' or '*' since '*' can act as an open parenthesis
            if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                openCount++;
            } else {
                // Decrement openCount for ')' because we assume it closes an open parenthesis
                openCount--;
            }

            // Process from the end of the string simultaneously for close parentheses
            // Increment closeCount for ')' or '*' since '*' can act as a close parenthesis
            if (s.charAt(n - i - 1) == ')' || s.charAt(n - i - 1) == '*') {
                closeCount++;
            } else {
                // Decrement closeCount for '(' because we assume it closes a close parenthesis
                closeCount--;
            }

            // If at any point closeCount or openCount goes negative, it means we have
            // too many closing parentheses without enough opening ones (or vice versa), so return false
            if (closeCount < 0 || openCount < 0) {
                return false;
            }
        }

        // If we managed to balance all parentheses, return true
        return true;
    }
}
