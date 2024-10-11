package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.*;

//https://leetcode.com/problems/maximum-units-on-a-truck/
public class MaximumUnits {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        //sort by unit per box, because we want max unit per box first, so we are greedy
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);

        int totalBoxes=0;
        int totalProfit=0;

        int n = boxTypes.length;

        for(int i=0;i<n;i++) {
            //inc total boxes and profit
            totalBoxes+=boxTypes[i][0];
            totalProfit+=boxTypes[i][1]*boxTypes[i][0];

            //total boxes becomes more than allowed so reduce and add only fractional
            if(totalBoxes>truckSize) {
                totalProfit=totalProfit-boxTypes[i][1]*boxTypes[i][0];
                totalBoxes=totalBoxes-boxTypes[i][0];
                int diffWeight = truckSize-totalBoxes;
                totalProfit+=diffWeight*boxTypes[i][1];
                return totalProfit;
            }
        }

        return totalProfit;

    }
}
