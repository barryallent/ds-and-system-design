package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.Arrays;

//https://leetcode.com/problems/maximum-length-of-pair-chain/description/
public class MaximumLengthOfPairChain {
        public int findLongestChain(int[][] pairs) {

            //sort based on endtime of meetings
            Arrays.sort(pairs, (a, b)->Integer.compare(a[1],b[1]));

            //track lastend time of meeting and total meetings
            int lastEndTime=-1001;
            int maxLength=0;

            for(int[] i:pairs) {

                //if current meeting start is greater than last end time then schedule meeting
                if(lastEndTime<i[0]) {
                    lastEndTime=i[1];
                    maxLength++;
                }
            }

            return maxLength;
        }
}
