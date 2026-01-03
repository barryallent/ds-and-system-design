package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
public class KthSmallestNumberInMultiplicationTable {
        //check how many numbers are less than x in matrix, this is a smart way to do it
        //because both column and rows are sorted, and we want less than O(n*n) complexity which is
        //avoided checking all numbers
        int countNumbersLessThanX(int x, int m, int n) {

            //we start with bottom left, we can start with top right also
            int row = m;
            int column = 1;
            int count = 0;

            while (row >= 1 && column <= n) {
                if (row * column <= x) {
                    count += row;
                    column++;
                } else {
                    row--;
                }
            }

            return count;

        }
        //in this question we will binary search on answer.
        //we will check how many elements are less than x
        //if numbers of elements less than x < k then we move to right because we want kth smallest
        //otherwise move to left bound
        public int findKthNumber(int m, int n, int k) {

            //answer range
            int start = 1;
            int end = (m)*(n);

            while (start < end) {
                int mid = start + (end - start) / 2;

                if (countNumbersLessThanX(mid, m, n) >= k) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            return end;

        }
}
