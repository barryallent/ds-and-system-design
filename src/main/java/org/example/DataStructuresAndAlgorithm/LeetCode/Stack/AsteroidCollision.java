package org.example.DataStructuresAndAlgorithm.LeetCode.Stack;

import java.util.*;

//https://leetcode.com/problems/asteroid-collision/description/
public class AsteroidCollision {
        public int[] asteroidCollision(int[] asteroids) {

            Stack<Integer> s1 = new Stack<>();

            for(int i=0;i<asteroids.length;i++) {
                int currentAesteroid=asteroids[i];
                boolean isCurrentDestroyed=false;

                //this is the collision condition when peak is greater than 0 i.e. moving right
                //and current element less than 0 i.e. moving left
                while(!s1.isEmpty() && s1.peek()>0 && currentAesteroid<0) {

                    //if negative mass is more then destroy positive one
                    if(s1.peek()<-1*(currentAesteroid)) {
                        s1.pop();
                    }

                    //if both equal then destry both, if current destroyed just break while loop
                    //so that it cant destroy anyone else
                    else if(s1.peek()==-1*(currentAesteroid)) {
                        s1.pop();
                        isCurrentDestroyed=true;
                        break;
                    }

                    //if negative mass is less then destroy that
                    else {
                        isCurrentDestroyed=true;
                        break;
                    }
                }

                //if current was not destroyed then add it
                if(!isCurrentDestroyed) {
                    s1.add(currentAesteroid);
                }
            }

            //convert stack to reverse array
            int n = s1.size();
            int[] remainingAesteroids = new int[n];
            int i=0;

            while(!s1.isEmpty()) {
                remainingAesteroids[n-i-1]=s1.pop();
                i++;
            }

            return remainingAesteroids;
        }
}
