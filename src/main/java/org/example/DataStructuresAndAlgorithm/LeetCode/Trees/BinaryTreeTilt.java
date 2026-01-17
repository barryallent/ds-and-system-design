package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/binary-tree-tilt/
public class BinaryTreeTilt {
    int totalTilt;
    int findTiltSum(TreeNode root) {
        if(root==null) {
            return 0;
        }

        int leftSum = findTiltSum(root.left);
        int rightSum = findTiltSum(root.right);

        int tilt = Math.abs(leftSum - rightSum);
        totalTilt+=tilt;

        return root.val + leftSum + rightSum;
    }
    public int findTilt(TreeNode root) {
        totalTilt=0;
        findTiltSum(root);
        return totalTilt;
    }
}
