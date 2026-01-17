package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class BinaryTreeMaximumPathSum {
    int maxPathSum;
    int getMaxPathSum(TreeNode root) {
        if(root==null) {
            return 0;
        }
        int leftSum = Math.max(getMaxPathSum(root.left),0);
        int rightSum = Math.max(getMaxPathSum(root.right),0);

        maxPathSum = Math.max(maxPathSum, root.val + leftSum + rightSum);

        return root.val + Math.max(leftSum,rightSum);
    }
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        getMaxPathSum(root);
        return maxPathSum;
    }
}
