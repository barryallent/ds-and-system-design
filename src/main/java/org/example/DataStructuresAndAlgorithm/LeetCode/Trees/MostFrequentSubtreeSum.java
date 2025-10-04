package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/most-frequent-subtree-sum/
public class MostFrequentSubtreeSum {
    //map to store frequencies of all subtree sums
    Map<Integer,Integer> sumFrequencies = new HashMap<>();

    //calculate sum of all subtrees and put in map
    int sumOfTree(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int leftSum = sumOfTree(root.left);
        int rightSum = sumOfTree(root.right);

        int sumOfSubTree = root.val + leftSum + rightSum;

        sumFrequencies.put(sumOfSubTree, sumFrequencies.getOrDefault(sumOfSubTree,0)+1);

        return sumOfSubTree;

    }
    public int[] findFrequentTreeSum(TreeNode root) {
        sumOfTree(root);

        int maxFrequency=0;

        List<Integer> maxSumList = new ArrayList<>();

        //get max frequency sum
        for(Map.Entry<Integer,Integer> entry: sumFrequencies.entrySet()) {
            maxFrequency=Math.max(maxFrequency, entry.getValue());
        }

        //get all the keys with maxFrequency
        for(Map.Entry<Integer,Integer> entry: sumFrequencies.entrySet()) {
            if(entry.getValue()==maxFrequency) {
                maxSumList.add(entry.getKey());
            }
        }

        //store list in array as asked in question
        int[] maxSumArray = new int[maxSumList.size()];

        for(int i=0;i<maxSumList.size();i++) {
            maxSumArray[i]=maxSumList.get(i);
        }

        return maxSumArray;
    }
}
