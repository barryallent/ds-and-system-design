package org.example.DataStructuresAndAlgorithm.LeetCode.Recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {
    boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start)!=s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        explore(s, 0, 0, new ArrayList<>(), result);
        return result;
    }
    private void explore(String s, int start, int end, List<String> current, List<List<String>> result) {
        if (end == s.length()) {
            // if we consumed whole string and all parts chosen are palindromes
            if (start == end) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        //basically at each poistion we have 2 options, do partitions or not
        // Option 1: cut here if substring is palindrome
        if (isPalindrome(s, start, end)) {
            current.add(s.substring(start, end + 1));
            //palindrom cut till end so move start and end to
            explore(s, end + 1, end + 1, current, result);
            current.remove(current.size() - 1);
        }

        // Option 2: don’t cut yet, extend substring
        explore(s, start, end + 1, current, result);
    }
}
