package org.example.LeetCode.Greedy;

//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

public class MinimumAddtoMakeParenthesesValid {
    public int minAddToMakeValid(String s) {

        //variables to track unmatched opening and closing brackets
        int unmatchedOpenCount=0;
        int unmatchedCloseCount=0;

        for(int i=0;i<s.length();i++) {

            //if opening bracket then it is initially unmatched so inc unmatchedOpenCount
            if(s.charAt(i)=='(') {
                unmatchedOpenCount++;
            }
            else {

                //if it's a close bracket, and we have unmatched open brackets then we found a matching
                // pair so reduce the unmatched open count
                if(unmatchedOpenCount>0) {
                    unmatchedOpenCount--;
                }

                //if there are no open brackets that means its a unmatched close bracket
                else {
                    unmatchedCloseCount++;
                }
            }
        }

        //return unmatched open and close brackets
        return unmatchedOpenCount+unmatchedCloseCount;

    }
}
