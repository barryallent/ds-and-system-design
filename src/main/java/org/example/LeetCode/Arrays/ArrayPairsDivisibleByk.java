package org.example.LeetCode.Arrays;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/description/
public class ArrayPairsDivisibleByk {
    public boolean canArrange(int[] arr, int k) {
        int n=arr.length;

        //store all remainder frequencies in this array, remainders can be from 0 to k-1
        int[] remainderFrequencies = new int[k];
        for(int i:arr) {

            //i%k is remainder we add k and % overall by k to handle negatives
            int remainder=(i%k+k)%k;
            remainderFrequencies[remainder]++;
        }

        //check remainder frequency i is equal to k-i, i=1 to k/2
        //basiscally remainder frequency 1 should be equal to k-1 so that some elements have
        //remainder 1 so they need to add into elements with remainder k-1 so that remainder is 0
        for(int i=1;i<=k/2;i++) {
            if(remainderFrequencies[i]!=remainderFrequencies[k-i]) {
                return false;
            }
        }

        //handle 0 case seperately
        if(remainderFrequencies[0]%2!=0) {
            return false;
        }
        return true;
    }
}
