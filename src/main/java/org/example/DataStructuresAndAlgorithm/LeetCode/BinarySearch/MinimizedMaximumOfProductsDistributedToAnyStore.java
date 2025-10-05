package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/
public class MinimizedMaximumOfProductsDistributedToAnyStore {
    //function to check if we can distribute quantities to n stores where each store can get
    //maxNumber
    boolean canDistribute(int n, int maxNumber, int[] quantities) {
        int totalQuantities=0;
        for(int i:quantities) {

            //[11,6] n=6 is quantities[i]=11 and maxNumber is 2 that means 11/2 so we need 6 stores to
            //distribute it and n is 6 so we need to divide 6 also that will be 3. So count becomes 9
            // so we cant distribute with max as 2 so we need max as > 2.
            // lets say max is 11 then we can easily distribute because some stores can get 0 also.
            int currentCount=i/maxNumber;
            if(i%maxNumber!=0) {
                currentCount++;
            }
            totalQuantities+=currentCount;
        }

        //check if totalQuantities is less than n because if its more that means
        //we are not able to break quantities[i] with max as maxNumber
        return totalQuantities<=n;
    }

    //apply binary search on answer
    public int minimizedMaximum(int n, int[] quantities) {
        int maxOfArray = Arrays.stream(quantities).max().getAsInt();
        int start = 1;
        int end = maxOfArray;

        while(start<=end) {
            int mid = start + (end-start)/2;
            if(canDistribute(n, mid, quantities)) {
                end = mid - 1;
            }
            else {
                start = mid+1;
            }
        }

        return end+1;
    }
}
