package org.example.LeetCode.Trees;

//https://leetcode.com/problems/unique-binary-search-trees/description/
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {

        //Number of trees for 5 nodes 1 2 3 4 5
        //first 1 will be root node so left side 0 elements and right side 4 elements
        //so number of trees with 1 as root node would be numberOfTrees[0]*numberOfTrees[4]
        //similarly number of trees with 2 as root node would be numberOfTrees[1]*numberOfTrees[3]

        //     numberOfTrees[n] = numberOfTrees[0]*numberOfTrees[n-1]+
        //                   numberOfTrees[1]*numberOfTrees[n-2]+
        //                   numberOfTrees[2]*numberOfTrees[n-3]+
        //                ...numberOfTrees[n-1]*numberOfTrees[0]
        int[] numberOfTrees = new int[n+1];

        //base case
        numberOfTrees[0]=1;
        numberOfTrees[1]=1;

        for(int i=2;i<n+1;i++) {
            for(int j=0;j<i;j++) {
                // from, above j is going from 0 to n-1
                numberOfTrees[i] += numberOfTrees[j]*numberOfTrees[i-j-1];
            }
        }

        return numberOfTrees[n];
    }
}
