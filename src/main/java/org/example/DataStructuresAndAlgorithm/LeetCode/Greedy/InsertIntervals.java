package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        //add new interval to intervals
        List<int[]> combinedInterval = new ArrayList<>();

        boolean addedNewInterval = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!addedNewInterval && intervals[i][0] > newInterval[0]) {
                combinedInterval.add(newInterval);
                addedNewInterval = true;
            }
            combinedInterval.add(intervals[i]);
        }

        //not added so its the greatest so add at last
        if(!addedNewInterval) {
            combinedInterval.add(newInterval);
        }


        //now same as merge intervals question for List combinedInterval
        List<int[]> mergedCombined = new ArrayList<>();
        int lastAddedEnd = -1;

        for (int[] i : combinedInterval) {
            if (lastAddedEnd >= i[0]) {
                int[] lastInterval = mergedCombined.get(mergedCombined.size() - 1);
                lastInterval[1] = Math.max(lastAddedEnd, i[1]);
                lastAddedEnd = Math.max(lastAddedEnd, i[1]);
            } else {
                mergedCombined.add(new int[] { i[0], i[1] });
                lastAddedEnd = i[1];
            }
        }

        return mergedCombined.toArray(new int[0][]);

    }
}
