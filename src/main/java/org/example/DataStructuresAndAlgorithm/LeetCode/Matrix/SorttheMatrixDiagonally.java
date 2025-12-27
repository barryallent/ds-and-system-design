package org.example.DataStructuresAndAlgorithm.LeetCode.Matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sort-the-matrix-diagonally/description/
public class SorttheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {


        //crux is that i-j is same for all elements on the diagonal
        //so we make a map and for a diagonal and put all elements of that diagonal in priority queue
        //then we iterate matrix again and for a element we get which diagonal it belongs to
        //by i-j and put the smallest element at that place that we get by pq and since we will
        Map<Integer, PriorityQueue<Integer>> matDiagonalMap = new HashMap<>();

        int m=mat.length, n=mat[0].length;

        //put all elements in priorityqueues diagonal wise
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int mapKey = i-j;
                PriorityQueue<Integer> pq = matDiagonalMap.getOrDefault(mapKey,new PriorityQueue<>());
                pq.add(mat[i][j]);
                matDiagonalMap.put(mapKey, pq);
            }
        }

        //assign the elements from pq
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                int mapKey = i-j;
                PriorityQueue<Integer> pq = matDiagonalMap.get(mapKey);
                mat[i][j]=pq.poll();
            }
        }
        return mat;
    }
}
