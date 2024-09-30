package org.example.LeetCode.Greedy;

import java.util.*;

class Time {
    int time;
    String type;
    int friendId;
    Time(int time, String type, int friendId) {
        this.friendId=friendId;
        this.time=time;
        this.type=type;
    }

    public String toString() {
        return "time= "+time+" type= "+type+" friendId= "+friendId;
    }
}

//https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/
public class SmallestUnoccupiedChair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        //add all times to a new array and sort by time
        //basically we will look at each entry sorted by time and add
        //or remove chairs according to type of the element, arrival or departure
        Time[] timesModified = new Time[2*n];
        int id=0;
        int index=0;

        //make combined array
        for(int[] i:times ) {
            Time t1 = new Time(i[0], "Arrival", id);
            Time t2 = new Time(i[1], "Departure", id);
            timesModified[index++] = t1;
            timesModified[index++] = t2;
            id++;
        }

        //sort by time, if time equal then we want to departure first
        Arrays.sort(timesModified, (a,b)->a.time == b.time ? b.type.compareTo(a.type) : a.time - b.time);

        //pq to track available chair, min heap because we want min of all chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        //add all chair till n-1 to pq, because max chair can be when all arrive at same time
        //so n friends to n chairs
        for(int i=0;i<n;i++) {
            availableChairs.add(i);
        }

        //to track which friends sit on which chair
        int[] friendToChair = new int[n];

        //now go through time and see if it is arrival or departure
        for(Time t:timesModified) {

            //if the target friend has arrived see from heap that which is the available chair from them
            if(t.friendId==targetFriend) {
                return availableChairs.peek();
            }

            //if arrival then find min available chair and sit the friend on that chair
            if(t.type.equals("Arrival")) {
                int chair = availableChairs.poll();
                friendToChair[t.friendId]=chair;
            }

            //if its a departure then find on chair the departing friend was sitting and add that
            //chair to available chairs
            else if(t.type.equals("Departure")) {
                int chair = friendToChair[t.friendId];
                availableChairs.add(chair);
            }
        }

        return availableChairs.peek();
    }

}
