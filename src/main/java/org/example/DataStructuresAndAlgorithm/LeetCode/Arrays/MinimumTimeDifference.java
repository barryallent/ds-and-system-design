package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

import java.util.*;

//https://leetcode.com/problems/minimum-time-difference/description/
public class MinimumTimeDifference {

    //get minutes from given time string, eg if time is 15:00 then minutes is 15*60
    int getMinutes(String s) {
        String[] timeSplit = s.split(":");
        int hour = Integer.valueOf(timeSplit[0]);
        int minute = Integer.valueOf(timeSplit[1]);

        return hour*60+minute;
    }

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] minutes = new int[n];

        int index=0;

        //make minutes array from time array
        for(String s1:timePoints) {
            minutes[index++]=getMinutes(s1);
        }

        //sort the minutes because we need to find min minutes difference so that we can look adjacent minutes
        Arrays.sort(minutes);

        int minimumTimeDifference = 1440;

        //compare adjacent minutes for min time difference
        for(int i=1;i<n;i++) {
            int differenceMinutes = minutes[i]-minutes[i-1];
            minimumTimeDifference=Math.min(minimumTimeDifference,differenceMinutes);
        }

        //calculate time diff b/w 1st and last minutes since it is circular
        //min will be either the absolute difference for going from last to first
        int circularDifference = Math.min(Math.abs(minutes[0]-minutes[n-1]),1440-minutes[n-1]+minutes[0]);

        minimumTimeDifference=Math.min(minimumTimeDifference,circularDifference);

        return minimumTimeDifference;
    }
}
