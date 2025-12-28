package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/description/

public class DistinctSubsequences {
        int[][] distinctSubsequencesMemo;

        //crux is that we need to use pointers just like LCS instead of trying to form all subsequences
        int numDistinct(int i, int j, String s, String t) {

            //reached end of t that means all char matched
            if (j >= t.length()) {
                return 1;
            }
            if (i >= s.length()) {
                return 0;
            }

            if (distinctSubsequencesMemo[i][j] != -1) {
                return distinctSubsequencesMemo[i][j];
            }

            int op1 = 0, op2 = 0;

            //if chars match then try to match next chars
            if (s.charAt(i) == t.charAt(j)) {
                op1 = numDistinct(i + 1, j + 1, s, t);
            }

            //if i dont match then move i to match with j
            op2 = numDistinct(i + 1, j, s, t);

            return distinctSubsequencesMemo[i][j] = op1 + op2;

        }

        public int numDistinct(String s, String t) {
            distinctSubsequencesMemo = new int[s.length()][t.length()];
            for (int[] i : distinctSubsequencesMemo)
                Arrays.fill(i, -1);
            return numDistinct(0, 0, s, t);
        }
}

//BottomUp
//class Solution {
//
//    public int numDistinct(String s, String t) {
//
//        int m=s.length();
//        int n=t.length();
//
//
//        //dp[i][j] represent how many suquences can be formed by taking 1st i chars of s that
//        // match first j chars of t
//        int[][] distinitSubsequencesMemo = new int[m+1][n+1];
//
//
//        //if t is empty then we have 1 way to match, (dont take anything from s)
//        for(int i=0;i<m;i++) {
//            distinitSubsequencesMemo[i][0]=1;
//        }
//
//
//        for(int i=1;i<=m;i++) {
//            for(int j=1;j<=n;j++) {
//                int op1=0,op2=0;
//
//                //if matching chars that means we need to check how many ways to form i-1, j-1
//                //because we are coming from there
//                if(s.charAt(i-1)==t.charAt(j-1)) {
//                    op1=distinitSubsequencesMemo[i-1][j-1];
//                }
//
//                //always count ways that are formed using i-1 chars in s
//                op2=distinitSubsequencesMemo[i-1][j];
//                distinitSubsequencesMemo[i][j]+=op1+op2;
//            }
//        }
//
//        return distinitSubsequencesMemo[m][n];
//    }
//}