package org.example.DataStructuresAndAlgorithm.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumOperationsToMakeUniValueGrid {
    // First we will see if it is possible even to make all elements equal by checking the remainder.
    // Then we will find out the final element of uniGrid and count the operations to make all elements equal to it
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        //check if all elements have same remainder after dividing with x
        // if remainder is not equal eg- [2,11][7,17] and x=5
        int remainder = grid[0][0]%x;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                //if we found unequal remainder then return from there
                if (grid[i][j] % x != remainder) {
                    return -1;
                }
            }
        }


        // Find out the element to which we should make all elements equal, for this we will make matrix flat
        // and sort and then try to make all elements equal to mid element
        List<Integer> flatGrid = new ArrayList<>();

        for (int[] i:grid) {
            for(int j:i) {
                flatGrid.add(j);
            }
        }

        Collections.sort(flatGrid);

        int finalElement = flatGrid.get(flatGrid.size()/2);

        int numberOfOperations = 0;

        //count number of operations
        for (int[] i:grid) {
            for(int j:i) {
                numberOfOperations+=Math.abs(j-finalElement)/x;
            }
        }

        return numberOfOperations;
    }
}
