package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {

        int[][] arr = {{1120, 1159}, {1508, 1529}, {1508, 1527}, {1503, 1600}, {1458, 1629}, {1224, 1313}};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        pq.add(arr[0][1]);
        int maxCars=0;

        for(int i=1;i< arr.length;i++) {
            System.out.println("car enter time"+arr[i][0]+" pq peek "+pq.peek());
            if(arr[i][0]>pq.peek()) {
                pq.poll();
            }
            pq.add(arr[i][1]);
            maxCars=Math.max(maxCars,pq.size());
        }
        System.out.println(maxCars);



        System.out.println("Hello world!");
    }
}