package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/problems/attend-all-meetings-ii/1
public class MeetingRoomsII {
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        int n = start.length;
        int[][] meetingTimes = new int[n][2];

        for(int i=0; i<n;i++) {
            meetingTimes[i][0]=start[i];
            meetingTimes[i][1]=end[i];
        }
        Arrays.sort(meetingTimes, (a, b)->Integer.compare(a[0],b[0]));

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        int currentMeetingRooms=0;

        int meetingRooms=0;

        for(int i=0;i<meetingTimes.length;i++) {
            while(!endTimes.isEmpty() && endTimes.peek()<=meetingTimes[i][0]) {
                endTimes.poll();
                currentMeetingRooms--;
            }
            currentMeetingRooms++;
            meetingRooms=Math.max(meetingRooms, currentMeetingRooms);
            endTimes.add(meetingTimes[i][1]);
        }

        return meetingRooms;
    }
}
