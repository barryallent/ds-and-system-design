package org.example.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/sum-of-subarray-minimums/description/
public class SumOfSubarrayMinimums {
    //define the modulo
    private static final int MOD = 1000000007;

    //get next smaller elements for elements of arr
    int[] getNextSmallerElement(int[] arr, Stack<int[]> s1) {
        int n = arr.length;
        int[] nextSmallerElement = new int[n];
        Arrays.fill(nextSmallerElement,-1);
        for(int i=0;i<n;i++) {
            while(!s1.isEmpty() && s1.peek()[1]>arr[i]) {
                int[] topElement = s1.pop();
                nextSmallerElement[topElement[0]]=i;
            }
            s1.push(new int[]{i,arr[i]});
        }
        return nextSmallerElement;
    }
    //get previous smaller elements for elements of arr
    int[] getPreviousSmallerElement(int[] arr, Stack<int[]> s1) {
        int n = arr.length;
        int[] previousSmallerElement = new int[n];

        Arrays.fill(previousSmallerElement,-1);

        for(int i=0;i<n;i++) {
            while(!s1.isEmpty() && s1.peek()[1]>=arr[n-i-1]) {
                int[] topElement = s1.pop();
                previousSmallerElement[topElement[0]]=n-i-1;
            }
            s1.push(new int[]{n-i-1,arr[n-i-1]});
        }
        return previousSmallerElement;
    }

    //basically we will look in how many subarrays ith element can occur as a minimum
    //idea would be to get previous smaller element index and next smaller element index
    //now the element would be included in arrays till previous smaller index to next smaller index
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        //get next smaller elements indices
        Stack<int[]> s1 = new Stack<>();
        int[] nextSmallerElement = getNextSmallerElement(arr, s1);

        //get previous smaller elements indices
        Stack<int[]> s2 = new Stack<>();
        int[] previousSmallerElement = getPreviousSmallerElement(arr, s2);

        long totalContribution = 0;
        for(int i=0;i<n;i++) {

            //contribution from left and right side
            int leftSide=0,rightSide=0;

            //if we have no next larger element then we take all elements till right
            if(nextSmallerElement[i]==-1) {
                rightSide=n-i;
            }
            //else take elements from i to next smaller index
            else {
                rightSide=nextSmallerElement[i]-i;
            }

            //if we have no previous larger element then we take all elements till left
            if(previousSmallerElement[i]==-1) {
                leftSide=i+1;
            }

            //else take elements from prev smaller index to i
            else {
                leftSide=i-previousSmallerElement[i];
            }

            //total subarrays formed that has ith element as smallerst is leftside*rightside
            long totalTimesIOccur = (long) leftSide * rightSide % MOD;

            //get contribution of i from total subarrays formed from i
            long totalIContribution = totalTimesIOccur * arr[i] % MOD;

            //add contribution of i to total contribution
            totalContribution = (totalContribution + totalIContribution) % MOD;
        }

        return (int) totalContribution;
    }
}
