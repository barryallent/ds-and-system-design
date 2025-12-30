package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/palindrome-partitioning-ii/description/
public class PalindromePartitioningII {
    int[] dp;
    boolean[][] isPalindromeDP;
    int n;

    boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    int minCut(int i, String s) {
        if (i >= n) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        //here we are only taking one variable because j is useless
        //we are only doing parition at front,
        //lets say we partition at k [i....k....j] then once i to k is palindrome
        //there is no subproblem to check (i,k-1) because we are checking the full left as palinfrome
        //so we need only right side so that we can take from k+1,n. no need of j
        //because we will keep doing partitions at start only.
        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < n; k++) {

            //if i to k is palindrom the partition at k and check the right half, otherwise
            //dont partition.
            if (isPalindromeDP[i][k]) {
                int cost = 1 + minCut(k + 1, s);
                minCost = Math.min(minCost, cost);
            }
        }

        return dp[i] = minCost;
    }

    public int minCut(String s) {
        n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);

        //this DP is added just to improve complexity, can work without it also
        //if we use isPalindrome(s,i,k) in recursion instead of isPalindromeDP[i][k]
        isPalindromeDP = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        isPalindromeDP[i][j] = true;
                    } else {
                        isPalindromeDP[i][j] = isPalindromeDP[i + 1][j - 1];
                    }
                }
            }
        }

        //minus 1 because we are counting one extra
        return minCut(0, s) - 1;
    }
}
