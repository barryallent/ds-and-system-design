package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/
public class KthSmallestElementInASortedMatrix {
        //check how many numbers are less than x in matrix, this is a smart way to do it
        //because both column and rows are sorted and we want less than O(n*n) complexity which is
        //avoid checking all numbers
        int countNumbersLessThanX(int x, int[][] matrix) {

            int n = matrix.length;
            int row = n - 1;
            int column = 0;
            int count = 0;

            while (row >= 0 && column < n) {
                if (matrix[row][column] <= x) {
                    count += row + 1;
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
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;

            //answer range
            int start = matrix[0][0];
            int end = matrix[n - 1][n - 1];

            while (start <= end) {
                int mid = start + (end - start) / 2;

                if (countNumbersLessThanX(mid, matrix) < k) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            //we want First ≥ k (lower_bound) so return start
            return start;
        }
}
