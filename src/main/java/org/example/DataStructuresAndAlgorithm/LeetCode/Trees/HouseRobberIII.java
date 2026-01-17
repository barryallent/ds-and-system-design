package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/house-robber-iii/description/
public class HouseRobberIII {
    public int rob(TreeNode root, Map<TreeNode,Integer> dp) {
        if (root == null) {
            return 0;
        }

        if(dp.containsKey(root)) {
            return dp.get(root);
        }

        int leftChildrensContribution = root.left != null ? rob(root.left.left, dp) + rob(root.left.right, dp) : 0;
        int rightChildrensContribution = root.right != null ? rob(root.right.left, dp) + rob(root.right.right, dp) : 0;

        int robCurrent = root.val + leftChildrensContribution + rightChildrensContribution;

        int notRobCurrent = rob(root.left, dp) + rob(root.right, dp);

        dp.put(root, Math.max(robCurrent, notRobCurrent));

        return Math.max(robCurrent, notRobCurrent);
    }

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }
}
