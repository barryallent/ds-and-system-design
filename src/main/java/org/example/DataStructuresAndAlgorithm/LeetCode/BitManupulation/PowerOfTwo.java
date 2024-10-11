package org.example.DataStructuresAndAlgorithm.LeetCode.BitManupulation;

//https://leetcode.com/problems/power-of-two/description/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if( n>0 && (n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }

//    public boolean isPowerOfTwo(int n) {
//        if( n>0 && (n - (n & -n)) == 0) {
//            return true;
//        }
//        return false;
//    }
}
