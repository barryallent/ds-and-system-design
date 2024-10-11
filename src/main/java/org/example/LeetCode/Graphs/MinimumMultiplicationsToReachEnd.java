package org.example.LeetCode.Graphs;

import java.util.*;

//https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
public class MinimumMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {

        int[] distances = new int[100000];

        int n = arr.length;

        Arrays.fill(distances,Integer.MAX_VALUE);

        PriorityQueue<int[]> q1 = new PriorityQueue<>((a,b)->a[1]-b[1]);

        q1.offer(new int[]{start,0});
        distances[start] = 0;

        while(!q1.isEmpty()) {
            int[] topElement = q1.poll();
            int element=topElement[0];
            int distance=topElement[1];

            if(distance>distances[element]) {
                continue;
            }


            for(int i = 0;i<n;i++) {
                int neighbour=(element*arr[i])%100000;
                if( distance+1 < distances[neighbour] ) {
                    distances[neighbour] = distance+1;
                    q1.offer(new int[]{neighbour,distance+1});
                }
            }
        }
        return distances[end]==Integer.MAX_VALUE?-1:distances[end];
    }

}
