package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class CustomComparator implements Comparator<long[]> {
    @Override

    //return with earlier end time
    public int compare(long[] a, long[] b) {
        if (a[0] != b[0]) {
            return Long.compare(a[0], b[0]);
        }
        //return meeting with slowest number
        else {
            return Long.compare(a[1], b[1]);
        }
    }
}

//https://leetcode.com/problems/meeting-rooms-iii/description/
public class MeetingRoomsIII {


     public int mostBooked(int n, int[][] meetings) {

            Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

            //minHeap based on entime to track which all meeting ended
            //stores meeting times and room in which meeting is happening (endTime, room)
            //starttime is not needed
            PriorityQueue<long[]> currentMeetings = new PriorityQueue<>(new CustomComparator());

            //minheap to track all empty rooms, we get lower empty room first
            //initially add all the rooms
            PriorityQueue<Integer> emptyRooms = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                emptyRooms.add(i);
            }

            //countmeetings in each room from 0 to n
            int[] countMeetingsInRooms = new int[n];


            for (int i = 0; i < meetings.length; i++) {

                int start = meetings[i][0];
                int end = meetings[i][1];
                int duration = end - start;

                //check if any room got empty
                while (!currentMeetings.isEmpty() && currentMeetings.peek()[0] <= start) {
                    long[] meeting = currentMeetings.poll();
                    int roomNumber = (int) meeting[1];
                    emptyRooms.add(roomNumber);

                }

                //check if we can schedule meeting
                if (!emptyRooms.isEmpty()) {
                    int meetingRoom = emptyRooms.poll();
                    currentMeetings.add(new long[] { end, meetingRoom });
                    countMeetingsInRooms[meetingRoom]++;

                }
                //if no empty room
                else {
                    // delay meeting to earliest ending room
                    long[] earliestEnd = currentMeetings.poll();

                    long newEndTime = earliestEnd[0] + duration;
                    currentMeetings.add(new long[]{newEndTime, earliestEnd[1]});
                    countMeetingsInRooms[(int) earliestEnd[1]]++;
                }
            }

            // find room with max meetings
            int roomWithMaxMeeting = 0;
            for (int i = 1; i < n; i++) {
                if (countMeetingsInRooms[i] > countMeetingsInRooms[roomWithMaxMeeting]) {
                    roomWithMaxMeeting = i;
                }
            }

            return roomWithMaxMeeting;

        }
}
