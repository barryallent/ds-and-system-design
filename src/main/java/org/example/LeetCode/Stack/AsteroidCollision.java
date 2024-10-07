package org.example.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/asteroid-collision/description/
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        Stack<Integer> s1 = new Stack<>();

        for(int i=0;i<n;i++) {
            boolean isEqualMass=false;

            //if empty or both are travelling sign then push
            if(s1.isEmpty() || asteroids[i]*asteroids[s1.peek()]>0) {
                s1.push(i);
            }

            //if stack top is going left and incoming elements wants to go right then push
            else if (asteroids[i]>0 && asteroids[s1.peek()]<0) {
                s1.push(i);
            }

            //collision case
            else {

                //while travelling in opposite directions and incoming mass is more or equal
                while(!s1.isEmpty() && asteroids[i]<0 && asteroids[s1.peek()]>0 && asteroids[s1.peek()]<=Math.abs(asteroids[i])) {

                    //if masses are equal then we destroy and break otherwise keep destroying
                    //till we found less mass
                    if(asteroids[s1.peek()]==Math.abs(asteroids[i])) {
                        isEqualMass=true;
                    }
                    s1.pop();
                    if(isEqualMass) break;
                }

                //push to stack if either stack got empty or stack top has element moving to left
                //and masses were not equal means element was not destroyed
                if((s1.isEmpty() || asteroids[s1.peek()]<0) && !isEqualMass) {
                    s1.push(i);
                }
            }


        }

        //make array from stack
        int size = s1.size();
        int[] finalAsteroids = new int[size];

        int index=0;
        while(!s1.isEmpty()) {
            finalAsteroids[size-index-1]=asteroids[s1.pop()];
            index++;
        }
        return finalAsteroids;
    }
}
