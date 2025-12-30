package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

//https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {
        Boolean[][] dp;
        boolean isMatch(int i, int j, int n1, int n2, String s, String p) {
            //base case when both reach end successfully
            if(i>=n1 && j>=n2) {
                return true;
            }

            //if j is finish but s has characters left,
            //please note that if s="abcxxx" and p="abc" then false is expected and not true
            //because as per question the matching should cover the entire string and not partial
            if(j>=n2) {
                return false;
            }

            if(dp[i][j]!=null) {
                return dp[i][j];
            }

            //wildcard matching, 2 cases, "Look Ahead" Pattern (check if j+1 is wildcard)
            //case 1: ignore the wildcard and move to j+2 because a* means 0 or more a chars
            //so we skip a and * both and move to j+2
            //case 2: match the ith char and move i+1 but keep j at wildcard only so that
            //we can match next char in future,so we are giving option for wildcard to match 1 char
            //2 char, 3 char etc by keeping j same and i increase by 1
            //but this will happen only if current chars match or we have a .
            if(j+1<n2 && p.charAt(j+1)=='*') {
                boolean match = (i < n1) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.') ?
                        isMatch(i+1, j, n1, n2, s, p): false;
                boolean skip = isMatch(i, j+2, n1, n2, s, p);
                return dp[i][j] = match || skip;
            }

            //chars match or we have a . so increase both
            else if((i < n1) && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) {
                return dp[i][j] = isMatch(i+1, j+1, n1, n2, s, p);
            }

            return dp[i][j] =  false;
        }

        public boolean isMatch(String s, String p) {
            int n1 = s.length();
            int n2 = p.length();
            dp=new Boolean[n1+1][n2+1];
            return isMatch(0, 0, n1, n2, s, p);
        }
}
