package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
public class CountGoodNodesInBinaryTree {
    int getGoodNodesCount(TreeNode root, int currentMax) {
        if (root == null) {
            return 0;
        }
        int totalGoodNodes = 0;
        if (root.val >= currentMax) {
            currentMax = root.val;
            totalGoodNodes++;
        }
        //since each recursion gets its own currentMax so we dont have to backtrack
        return totalGoodNodes + getGoodNodesCount(root.left, currentMax) +
                getGoodNodesCount(root.right, currentMax);

    }

    public int goodNodes(TreeNode root) {
        return getGoodNodesCount(root, Integer.MIN_VALUE);

    }
}
