package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/
public class WordBreak {
    Boolean[][] checkWordsMemo;

    //take 2 pointers to iterate
    boolean checkWordBreak(int i, int j, String s, Set<String> words) {

        //if both are equal and reach length then return because when they match we make both same(j+1)
        if (i == j && i == s.length()) {
            return true;
        }

        //otherwise if j reach end then false
        if (j >= s.length()) {
            return false;
        }

        if(checkWordsMemo[i][j]!=null) {
            return checkWordsMemo[i][j];
        }

        boolean op1 = false, op2 = false;

        //if substring is found in words then we can just move i and j to j+1 to match next
        if (words.contains(s.substring(i, j+1))) {
            op1 = checkWordBreak(j + 1, j + 1, s, words);
        }

        //this case is always possible that we want to extend the search, (even in case of match this
        // we can do)
        op2 = checkWordBreak(i, j + 1, s, words);

        return checkWordsMemo[i][j] = op1 || op2;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        checkWordsMemo = new Boolean[s.length()][s.length()];

        //put all words in set to search in constant time
        Set<String> words = new HashSet<>();
        for (String s1 : wordDict) {
            words.add(s1);
        }

        int n = s.length();

        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(words.contains(s.substring(i, j+1))) {
                    dp[i][j] = dp[i-1][j-1];
                }

            }
        }

        return checkWordBreak(0, 0, s, words);

    }

    //bottomup solution
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        //put all words in set to search in constant time
//        Set<String> words = new HashSet<>(wordDict);
//
//        int n = s.length();
//
//        //dp[k] represent if we till length k we can form words from dict
//        boolean[] dp = new boolean[n+1];
//
//        //length 0 string can be formed for dict words
//        //we are kind of shifting one index, we will start from 1st index
//        dp[0]=true;
//
//
//        //at all index we will try to check
//        for(int i=1;i<n+1;i++) {
//
//            //eg s='leeleetcode' and words=['lee','leet', 'code']
//            //so at i=7 i.e at index 6 i.e at t we will check for j=0 to 6
//            //so when j is 3 i.e substring is leet and dp[3] is true because lee also exist
//            //so that means till leeleet we can form it using words
//            for(int j=0;j<i;j++) {
//                if(dp[j] && words.contains(s.substring(j,i))) {
//                    dp[i]=true;
//                    break;
//                }
//            }
//        }
//
//        return dp[n];
//
//    }
}
