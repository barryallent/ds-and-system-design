package org.example.LeetCode;

import java.util.*;

//https://leetcode.com/problems/candy/description/
public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;

        //consider only the left side and make an array of candies needed
        //then consider only thr right side and make an array of candies needed
        //the candy should satisy both left and right so it should be max of 2

        int[] candiesFromLeft = new int[n];
        int[] candiesFromRight = new int[n];

        candiesFromLeft[0]=1;
        candiesFromRight[n-1]=1;

        for(int i=1;i<n;i++) {
            //if candidate bigger than left so inc candy else give it 1
            //so this way we are considering only left neighbour
            if(ratings[i]>ratings[i-1]) {
                candiesFromLeft[i]=candiesFromLeft[i-1]+1;
            }
            else {
                candiesFromLeft[i]=1;
            }
            //if candidate bigger than right so inc candy else give it 1
            //so this way we are considering only right neighbour
            if(ratings[n-i-1]>ratings[n-i]) {
                candiesFromRight[n-i-1]=candiesFromRight[n-i]+1;
            }
            else {
                candiesFromRight[n-i-1]=1;
            }
        }

        int totalCandies=0;

        //now candy needed will be max of 2
        for(int i=0;i<n;i++) {
            totalCandies+=Math.max(candiesFromLeft[i],candiesFromRight[i]);
        }

        return totalCandies;
    }
}
