package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/description/
public class NonOverlappingIntervals {
        public int eraseOverlapIntervals(int[][] intervals) {

            //find total non overlapping intervals, then answer would be n-overlapping intervals
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

            int lastIntervalEnd = Integer.MIN_VALUE;

            int nonOverLappingIntervals = 0;

            for (int[] i : intervals) {
                if (lastIntervalEnd <= i[0]) {
                    lastIntervalEnd = i[1];
                    nonOverLappingIntervals++;
                }
            }

            return intervals.length - nonOverLappingIntervals;
        }
}
