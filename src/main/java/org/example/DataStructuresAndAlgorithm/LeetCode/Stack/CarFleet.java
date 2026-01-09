package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/car-fleet/description/
public class CarFleet {
        public int carFleet(int target, int[] position, int[] speed) {

            //we will make combined position and speed array and sort on basis of position.
            int n = position.length;
            int[][] positionsAndSpeed = new int[n][2];

            for(int i=0;i<n;i++) {
                positionsAndSpeed[i][0]=position[i];
                positionsAndSpeed[i][1]=speed[i];
            }

            Arrays.sort(positionsAndSpeed, (a, b)-> a[0]-b[0]);

            //we will have stack that stores the time taken to reach end for each car
            //idea is to start with the last car and push the time taken to reach target in stack
            //now when we go to next value we check if this can be part of the fleet. It can be part of
            //fleet if it reaches end before the car in the stack that means its speed will be more and
            //somewhere it will collide
            //we are starting from end because the end car never changes speed
            //otherwise if we start from left then we dont know when the car will actually reach end
            //because it can collide with other cars and slow down
            Stack<Double> s1 = new Stack<>();

            for(int i=n-1;i>=0;i--) {
                //find time to reach end for this car
                double currentTimeTaken=1.0*(target-positionsAndSpeed[i][0])/(positionsAndSpeed[i][1]);
                boolean isFleet=false;

                //if it reaches the end before the car in stack that means it become fleet with that
                //car so just break loop and no need to add this car as we already have a car for that fleet
                //so if someone needs to match this fleet they need to reach end before this car\
                //so out stack will have monotonic inreasing times to reach end from right to left
                while(!s1.isEmpty() && s1.peek()>=currentTimeTaken) {
                    isFleet=true;
                    break;
                }

                //if it didn't became fleet that means its slow and will be part of next fleet
                //so next time we will check if any car takes less time that this one to reach end
                //and that car will join this fleet because it will collide with this one first
                if(!isFleet) {
                    s1.add(currentTimeTaken);
                }

            }

            return s1.size();
    }
}
