package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/description/
public class TakingMaximumEnergyFromTheMysticDungeon {
    int[][] maxEnergyMemo;

    //recursive function as we have 2 choices either select the first element or skip
    int maxEnergy(int i, int[] energy, int k, int isFirstElementSelected) {
        if(i>=energy.length) {
            return 0;
        }

        //need to select last element if no element already selected
        if(isFirstElementSelected==0 && i==energy.length-1) {
            return energy[i];
        }

        if(maxEnergyMemo[i][isFirstElementSelected]!=Integer.MIN_VALUE) {
            return maxEnergyMemo[i][isFirstElementSelected];
        }

        int op1 = energy[i] + maxEnergy(i+k, energy, k, 1);

        //keep op2 as MIN_VALUE so that we don't just select 1 element and dont move further
        int op2 = Integer.MIN_VALUE;

        //skip element only when 1st element is not selected, if 1st element selected then we
        //have to keep selecting all.
        if(isFirstElementSelected==0) {
            op2 = maxEnergy(i+1, energy, k, 0);
        }

        return maxEnergyMemo[i][isFirstElementSelected] = Math.max(op1,op2);
    }
    public int maximumEnergy(int[] energy, int k) {
        maxEnergyMemo = new int[energy.length][2];
        for(int[] i:maxEnergyMemo) {
            Arrays.fill(i, Integer.MIN_VALUE);
        }
        return maxEnergy(0, energy, k, 0);
    }
}
