package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

//https://leetcode.com/problems/path-sum-iii/description/
class TreeNode {
    int val;
    TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}

public class PathSumIII {
    int countPaths(TreeNode root, int targetSum, long currentSum, Map<Long,Integer> prefixSum) {
        if(root==null) {
            return 0;
        }
        currentSum+=root.val;

        //look if currentsum-targetsum is in hashmap and how many times
        int currentCount = prefixSum.getOrDefault(currentSum - targetSum,0);

        //put currentsum in hashmap
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        //answer would be count from this node, plus explore left and right path
        int totalCount = currentCount + countPaths(root.left,targetSum,currentSum, prefixSum)
                +countPaths(root.right,targetSum,currentSum, prefixSum);

        //backtrack, basially we are going to different path so we remove previous path sums
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) - 1);

        return totalCount;

    }

    public int pathSum(TreeNode root, int targetSum) {

        //use hashmap to store previously seen sum, this is the crux, if sum now is target+x
        //then we know that if we found x in hashmap then we can subtract that from currentsum to
        //get targetsum, currentSum-previousSum=targetSum
        //so we keep adding the currentSums to hashmap lets say currentSum now is 18 and target sum
        //is 8 so we will find if sum of 10 occured before, that we can find in constant time
        //from hashmap and then we can subtract that to get 8
        Map<Long,Integer> prefixSum = new HashMap<>();

        //put 0 in hashmap, because if currentsum=targetsum so we need 0 in hashmap
        prefixSum.put(0L,1);
        return countPaths(root, targetSum, 0L, prefixSum);
    }
}
