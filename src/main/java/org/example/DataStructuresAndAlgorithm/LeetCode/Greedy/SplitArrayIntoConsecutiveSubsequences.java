package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {

        //the idea of this question is that a element can go to the existing group or create a new group
        //if it goes to an existing group then there will be a vacancy for that in vacancymap
        //so we will consume that vacancy and create a vacancy for next element
        //otherwise we will use next 2 elements in the sequence and create a vacancy for the i+3 element
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        Map<Integer,Integer> vacancyMap = new HashMap<>();

        //count frequency of all elements
        for(int i:nums) {
            frequencyMap.put(i,frequencyMap.getOrDefault(i,0)+1);
        }

        //iterate array
        for(int i:nums) {

            //if element is already consumed by previous element then just continue
            if(frequencyMap.getOrDefault(i,0)<=0) {
                continue;
            }

            //reduce this element frequency because we will be using it either in new group or existing
            //group
            frequencyMap.put(i,frequencyMap.getOrDefault(i,0)-1);

            //if there is vacancy for the element then we use that by reducing frequency and create
            //vacancy for next element because now that can also be part of this group
            if(vacancyMap.getOrDefault(i,0)>0) {
                vacancyMap.put(i, vacancyMap.getOrDefault(i,0)-1);
                vacancyMap.put(i+1, vacancyMap.getOrDefault(i+1,0)+1);
            }

            //if no vacancy then we use i+1, i+2 to create new group and leave vacancy for i+3
            else {
                if(frequencyMap.getOrDefault(i+1,0)>0 && frequencyMap.getOrDefault(i+2,0)>0) {
                    frequencyMap.put(i+1,frequencyMap.getOrDefault(i+1,0)-1);
                    frequencyMap.put(i+2,frequencyMap.getOrDefault(i+2,0)-1);
                    vacancyMap.put(i+3, vacancyMap.getOrDefault(i+3,0)+1);
                }

                //if no vacancy and next 2 elements are also not available to form group then return false
                else {
                    return false;
                }
            }

        }
        return true;

    }
}
