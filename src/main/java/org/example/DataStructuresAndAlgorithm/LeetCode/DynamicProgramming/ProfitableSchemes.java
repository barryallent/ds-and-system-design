package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/profitable-schemes/description/
public class ProfitableSchemes {
    int[][][] profitableSchemesMemo;

    int modulo = 1000_000_000+7;

    int getProfitableSchemesCount(int i, int n, int minProfit, int[] group, int[] profit,
                                  int currentProfit, int currentPeopleCount) {

        //we are not returning early, we will just reach the end and check these 2 conditions
        //its like generating all the subsequences but instead of return 1 always, we only consider the
        //subset which fullfills these 2 conditions
        if (i >= profit.length) {
            return currentProfit >= minProfit && currentPeopleCount <= n ? 1 : 0;
        }

        if(profitableSchemesMemo[i][currentProfit][currentPeopleCount]!=-1) {
            return profitableSchemesMemo[i][currentProfit][currentPeopleCount];
        }

        //capped profit to save memory and eventually time
        int cappedProfit = Math.min(minProfit, currentProfit);

        int op1 = 0;

        //if condition just to avoid out of bounds as we have taken size only n+1
        if (currentPeopleCount + group[i] <= n) {
            op1 = getProfitableSchemesCount(i + 1, n, minProfit, group, profit,
                    Math.min(currentProfit + profit[i], minProfit), currentPeopleCount + group[i]);
        }

        int op2 = getProfitableSchemesCount(i + 1, n, minProfit, group, profit, cappedProfit,
                currentPeopleCount);

        return profitableSchemesMemo[i][currentProfit][currentPeopleCount] = (op1 + op2) % modulo;
    }

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int sumOfProfit = Arrays.stream(profit).sum();
        profitableSchemesMemo = new int[group.length][minProfit + 1][n+1];
        for (int[][] i : profitableSchemesMemo) {
            for (int[] j : i)
                Arrays.fill(j, -1);
        }
        return getProfitableSchemesCount(0, n, minProfit, group, profit, 0, 0);
    }
}
