package org.example.DataStructuresAndAlgorithm.LeetCode.Greedy;

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {

        // Function to get the maximum total value in the knapsack.
        double fractionalKnapsack(int w, Item arr[], int n) {


            //be greedy and sort by profit by weight ratio
            Arrays.sort(arr, (a, b) -> Double.compare((double)b.value / b.weight, (double)a.value / a.weight));

            int totalWeight=0;
            double totalProfit=0;

            //keep picking best items
            //if weight becomes > allowed weight then take fraction of element
            for(int i=0;i<n;i++) {
                totalProfit+=arr[i].value;
                totalWeight+=arr[i].weight;
                double profitRatio = (double) arr[i].value / arr[i].weight;
                if(totalWeight>w) {
                    totalProfit=totalProfit-arr[i].value;
                    totalWeight=totalWeight-arr[i].weight;
                    int diffWeight = w-totalWeight;
                    totalProfit+=diffWeight*profitRatio;
                    return totalProfit;

                }
            }

            return totalProfit;
        }
    }
