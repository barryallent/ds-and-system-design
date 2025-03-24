package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/count-days-without-meetings/
public class CountDaysWithoutMeeting {
    public int countDays(int days, int[][] meetings) {

        //code to do merge intervals
        Arrays.sort(meetings, (a, b)-> a[0]-b[0]);
        List<int[]> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(meetings[0]);

        for(int[] i : meetings ) {
            int[] lastMeeting = mergedMeetings.get(mergedMeetings.size()-1);
            if(lastMeeting[1]>=i[0]) {
                lastMeeting[1]=Math.max(lastMeeting[1],i[1]);
            }
            else {
                mergedMeetings.add(i);
            }
        }

        //calculate total meeting days
        int meetingDaysCount=0;
        for(int[] i:mergedMeetings) {
            meetingDaysCount+=i[1]-i[0]+1;
        }
        return days-meetingDaysCount;
    }
}
