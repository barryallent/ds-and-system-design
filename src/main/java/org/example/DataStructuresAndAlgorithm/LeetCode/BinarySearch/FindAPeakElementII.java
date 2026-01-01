package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/find-a-peak-element-ii/description/
public class FindAPeakElementII {

        //find max element and its index in an array
        int[] getMaxElementDetails(int[] arr) {
            int maxElement = 0;
            int maxElementIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= maxElement) {
                    maxElement = arr[i];
                    maxElementIndex = i;
                }
            }

            return new int[] { maxElement, maxElementIndex };
        }

        public int[] findPeakGrid(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;

            //idea is that we need to reduce search space somehow, we will be doing binary search on rows
            //in each row we will be finding that max element because that element will be greater than
            //right and left neighbour and then we just have to check if we should move up or down
            //that will be similar to peak element 1
            int start = 0, end = m - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;

                //get maxelement in the mid row
                int[] maxDetails = getMaxElementDetails(mat[mid]);
                int index = maxDetails[1];
                int element = maxDetails[0];

                //this element is already greater than left and right neighbour
                //if it is less than upper neighbour, then search space becomes upper rows so
                //we make end=mid-1
                if (mid - 1 >= 0 && element < mat[mid-1][index]) {
                    end = mid - 1;
                }
                //if below element is larger then this element then search space becomes below rows
                //so we make start=mid+1
                else if (mid + 1 < m && element < mat[mid+1][index]) {
                    start = mid + 1;
                }
                //otherwise this element is neither less than upper or lower and its already greater than
                //left and right because it was max in row, so that means this fullfills all conditions
                //to be peak element
                else {
                    return new int[] { mid, index };
                }

            }
            return new int[] { 0, 0 };
        }
}
