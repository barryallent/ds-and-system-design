package org.example.LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/insert-interval/
public class InsertIntervals {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            //just add the interval, and rest all same as merge intervals question
            List<int[]> addedIntervals = new ArrayList<>();

            boolean newIntervalAdded = false;

            //copy intervals to new array addedIntervals, since array is already sorted in
            //inc order so we want to insert newInterval accordingly
            for(int[] i : intervals) {
                //add new interval
                if(!newIntervalAdded && newInterval[0]<=i[0]) {
                    addedIntervals.add(newInterval);
                    newIntervalAdded=true;
                }
                addedIntervals.add(i);
            }

            //if interval didn't got added because it must be coming on end so add it
            if(!newIntervalAdded) {
                addedIntervals.add(newInterval);
            }

            //Array is sorted  by start time because we keep adding to array so we want min start element first
            //if we sort by end time and intervals is (3,5) (6,10) (1,100)
            //so answer will be (3,5) (6,100) but ideally answer should be (1,100)


            List<int[]> mergedIntervals = new ArrayList<>();

            mergedIntervals.add(addedIntervals.get(0));

            // int lastAdded = mergedIntervals.get(mergedIntervals.size()-1)[1];

            for(int i = 1; i < addedIntervals.size();i++) {

                int lastAdded[] = mergedIntervals.get(mergedIntervals.size()-1);

                //overlap so only update the end and no need to add
                if(lastAdded[1]>=addedIntervals.get(i)[0]) {
                    lastAdded[1]=Math.max(lastAdded[1],addedIntervals.get(i)[1]);
                }
                //no overlap so directly add
                else {
                    mergedIntervals.add(addedIntervals.get(i));
                }
            }

            return mergedIntervals.toArray(new int[0][]);

        }
    }}
