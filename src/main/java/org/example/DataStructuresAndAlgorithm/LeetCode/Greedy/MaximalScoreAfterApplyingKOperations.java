package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.*;

//https://leetcode.com/problems/maximal-score-after-applying-k-operations/
public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {

        //pq to highest topElement each time
        PriorityQueue<Integer> p1 = new PriorityQueue<Integer>((a,b)->b - a);

        //add all numbers to pq initially
        for(int i:nums) {
            p1.add(i);
        }

        //keep removing highest element from queue and add back ceil(highest/3)
        long sum=0L;
        while(k>0) {
            int topElement = p1.poll();
            sum+=topElement;
            if(topElement%3!=0) {
                p1.add(topElement/3+1);
            }
            else {
                p1.add(topElement=topElement/3);
            }
            k--;
        }
        return sum;
    }
}
