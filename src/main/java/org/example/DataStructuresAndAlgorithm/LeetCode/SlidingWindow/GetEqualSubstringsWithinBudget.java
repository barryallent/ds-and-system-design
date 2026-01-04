package org.example.DataStructuresAndAlgorithm.LeetCode.SlidingWindow;

//https://leetcode.com/problems/get-equal-substrings-within-budget/description/
public class GetEqualSubstringsWithinBudget {
        public int equalSubstring(String s, String t, int maxCost) {
            int n = s.length();
            int r=0;
            int l=0;
            int maxLength=0;

            int currentCost=0;

            while(r<n) {
                currentCost += Math.abs(s.charAt(r)-t.charAt(r));

                while(currentCost>maxCost && l<n) {
                    currentCost -= Math.abs(s.charAt(l)-t.charAt(l));
                    l++;
                }
                maxLength=Math.max(maxLength,r-l+1);
                r++;
            }
            return maxLength;
        }
}
