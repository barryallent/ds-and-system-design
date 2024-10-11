package org.example.DataStructuresAndAlgorithm.ExtraQuestions;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/minimum-swaps/1
//solution explanation: https://www.youtube.com/watch?v=m-8_yQao-lI
public class MinSwaps {
    public int minSwaps(int nums[]) {
        int n=nums.length;
        int swapNeeded=0;
        int[][] combinedNums = new int[n][2];
        for(int i=0;i<n;i++) {
            combinedNums[i][0]=nums[i];
            combinedNums[i][1]=i;
        }
        Arrays.sort(combinedNums,(a, b)->a[0]-b[0]);
        boolean[] visited = new boolean[n];

        for(int i=0;i<n;i++) {
            if(visited[i] || combinedNums[i][1]==i) {
                continue;
            }

            int cycleLength=0;
            int j=i;
            while(!visited[j]) {
                visited[j]=true;
                j=combinedNums[j][1];
                cycleLength++;
            }
            swapNeeded+=(cycleLength-1);
        }

        return swapNeeded;
    }
}
