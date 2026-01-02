package org.example.DataStructuresAndAlgorithm.LeetCode.BinarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/heaters/description/
public class Heaters {

        //checks if we can all houses can get the heat from heaters with range as radius
        boolean isPossibleToHeatHouses(int[] houses, int[] heaters, int radius) {
            int maxRadius=0;
            int heaterIndex=0;

            //check if all houses can be heated
            for(int i=0;i<houses.length;i++) {

                //while the next heater is closer to this house we increment it
                //why this works? If increasing heaterIndex reduces the distance we are doing it
                //imagine 2 arrays overlapping cases by drawing diagrams to understand all possible cases
                //think about it, both arrays are sorted and if increasing heaterIndex helps ith element
                //then it will definately help the (i+1)th element in all cases.
                //so it it helps we do it till the best is possible, this is in turn helping
                //all the elements in array. So this is the best we can do and then we check.
                //so think like this, for each house we are checking if any close better heater
                //possible and then we do the final check
                while(heaterIndex+1<heaters.length && Math.abs(houses[i]-heaters[heaterIndex])>=
                        Math.abs(houses[i]-heaters[heaterIndex+1])) {
                    heaterIndex++;
                }

                //we got the closest heater now check if it can heat the house with range as radius
                if( Math.abs(houses[i]-heaters[heaterIndex])>radius) {
                    return false;
                }
            }
            return true;
        }

        //binary search on answer
        public int findRadius(int[] houses, int[] heaters) {

            int n = houses.length;
            int m = heaters.length;
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int start = 0;
            //this is the max range possible, we are just calculating max distances possible,
            //since both arrays are sorted
            int end = Math.abs(Math.max(houses[n-1], heaters[m-1])-Math.min(houses[0], heaters[0]));

            while (start <= end) {
                int mid = start + (end - start) / 2;

                //if this range is possible we check smaller range, because we want min
                if (isPossibleToHeatHouses(houses, heaters, mid)) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            //we want min so lower bound
            return start;

        }
}
