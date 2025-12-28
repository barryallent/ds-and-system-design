package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.Arrays;

//https://leetcode.com/problems/last-stone-weight-ii/description/
public class LastStoneWeightII {
    int n;
    int[][] lastStoneWeightMemo;

    //this can become same as target sum if we think like this
    //divide all stones in 2 groups A and B with sum S1 and S2, you need to minimize (S1-S2)
    //because when stones smash they cancel out
    //so for (S1-S2) to be min, we will try to calculate one sum that is closer to totalSum/2
    //if its equal to totalSum/2 then s2 also becomes totalSum/2 and diff is 0
    int lastStoneWeight(int i, int[] stones, int currentSum, int targetSum) {
        if (i >= n) {
            return 0;
        }

        if (lastStoneWeightMemo[i][currentSum] != -1) {
            return lastStoneWeightMemo[i][currentSum];
        }

        int op1 = 0;
        //take stones only if by adding we are under target
        if (currentSum + stones[i] <= targetSum) {
            op1 = stones[i] + lastStoneWeight(i + 1, stones, currentSum + stones[i], targetSum);
        }

        int op2 = lastStoneWeight(i + 1, stones, currentSum, targetSum);

        //max because we want sum closer to targetSum
        return lastStoneWeightMemo[i][currentSum] = Math.max(op1, op2);
    }

    public int lastStoneWeightII(int[] stones) {
        n = stones.length;

        int sumOfStones = Arrays.stream(stones).sum();
        lastStoneWeightMemo = new int[n][(sumOfStones / 2) + 1];

        for (int[] i : lastStoneWeightMemo)
            Arrays.fill(i, -1);

        //find sum that is closest to targetSum i.e halfsum
        int closestHalfSumPossible = lastStoneWeight(0, stones, 0, sumOfStones / 2);

        //if one part has sum closestHalfSumPossible then other part has sum
        //(sumOfStones-closestHalfSumPossible) so their diff is
        //(sumOfStones-closestHalfSumPossible)-closestHalfSumPossible
        return sumOfStones-2*closestHalfSumPossible;
    }

    //Bottom UP
//    public int lastStoneWeightII(int[] stones) {
//
//        int sumOfStones = Arrays.stream(stones).sum();
//        int targetSum=sumOfStones/2;
//
//        boolean[] dp = new boolean[targetSum+1];
//        dp[0]=true;
//
//        for(int i:stones) {
//            for(int j=targetSum;j>=0;j--) {
//                if(dp[j] && j+i<targetSum+1) {
//                    dp[j+i]=true;
//                }
//            }
//        }
//
//        int closestHalfSumPossible=0;
//
//        for(int i=targetSum;i>=0;i--) {
//            if(dp[i]) {
//                closestHalfSumPossible=i;
//                break;
//            }
//        }
//
//        return sumOfStones-2*closestHalfSumPossible;
//
//    }
}
