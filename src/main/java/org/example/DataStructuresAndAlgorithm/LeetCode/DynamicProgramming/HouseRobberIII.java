package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/house-robber-iii/
public class HouseRobberIII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        Map<TreeNode, Integer> dp = new HashMap<>();

        int getMaxAmount(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (dp.containsKey(root)) {
                return dp.get(root);
            }

            int getMaxAmountLeftNeighbours = 0, getMaxAmountRightNeighbours = 0;
            if (root.left != null) {
                getMaxAmountLeftNeighbours = getMaxAmount(root.left.left) + getMaxAmount(root.left.right);
            }
            if (root.right != null) {
                getMaxAmountRightNeighbours = getMaxAmount(root.right.left) + getMaxAmount(root.right.right);
            }

            //getMaxAmount root
            int op1 = root.val + getMaxAmountLeftNeighbours + getMaxAmountRightNeighbours;

            //not getMaxAmount root
            int op2 = getMaxAmount(root.right) + getMaxAmount(root.left);

            dp.put(root, Math.max(op1, op2));

            return Math.max(op1, op2);

        }

        public int rob(TreeNode root) {
            return getMaxAmount(root);
        }
}
