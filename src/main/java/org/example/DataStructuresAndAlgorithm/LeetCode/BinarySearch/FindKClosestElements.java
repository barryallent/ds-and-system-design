package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-k-closest-elements/description/
public class FindKClosestElements {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {

            //we are trying to form window leftIndex to leftIndex+k-1 so we do binary search on where
            //can the leftIndex of array be.

            //this is the range for leftIndex
            int left = 0;
            int right = arr.length - k;

            while (left < right) {
                int mid = left + (right - left) / 2;

                //Now this is critical part, we take 1st element of our window
                // and check with 1st element of next window possible i.e (leftIndex+k-1) + 1
                //if it has better distance (lesser) then we need to consider moving left to that side
                //cant use absolutes here so somehow
                if (x - arr[mid] > arr[mid+k] - x) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            List<Integer> result = new ArrayList<>();

            //our leftIndex would be lowerBound i.e left so now we know the leftIndex and elements to take
            //we form the answer
            for (int i = left; i < left + k; i++) {
                result.add(arr[i]);
            }
            return result;
        }
}
