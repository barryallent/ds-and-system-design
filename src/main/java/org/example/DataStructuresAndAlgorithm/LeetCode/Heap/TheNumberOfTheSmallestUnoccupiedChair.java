package org.example.DataStructuresAndAlgorithm.LeetCode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
public class TheNumberOfTheSmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {

        //make new array since we need index of targetFriend conserved
        int n = times.length;
        int[][] sortedTimesWithIndex = new int[n][3];

        for(int i=0;i<n;i++) {
            sortedTimesWithIndex[i][0]=times[i][0];
            sortedTimesWithIndex[i][1]=times[i][1];
            sortedTimesWithIndex[i][2]=i;
        }

        //sort on basis of start time
        Arrays.sort(sortedTimesWithIndex, (a, b)->Integer.compare(a[0],b[0]));


        //(departure time, chair)
        PriorityQueue<int[]> departureTimes = new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));

        //add all infinite chair, can be max n, minheap since we need smallest chair at any time
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        for(int i=0;i<n;i++) {
            availableChairs.add(i);
        }


        for(int i=0;i<n;i++) {

            //when new friend arrives check if any chair got empty
            while(!departureTimes.isEmpty() && departureTimes.peek()[0]<=sortedTimesWithIndex[i][0]) {
                int[] departed = departureTimes.poll();
                int chair = departed[1];
                availableChairs.add(chair);
            }

            //get smallest available chair and sit friend
            int chairToSit = availableChairs.poll();
            if(targetFriend==sortedTimesWithIndex[i][2]) {
                return chairToSit;
            }
            departureTimes.add(new int[]{sortedTimesWithIndex[i][1],chairToSit});
        }

        return availableChairs.poll();

    }
}
