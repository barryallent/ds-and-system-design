package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/description/
public class CountNodesEqualToAverageOfSubtree {
    int totalNodesWithAverage;
    int[] getSumAndCount(TreeNode root) {
        if(root==null) {
            return new int[]{0,0};
        }

        int[] left = getSumAndCount(root.left);
        int[] right = getSumAndCount(root.right);

        int sum = root.val+left[0]+right[0];
        int nodes = 1+left[1]+right[1];

        int average = sum/nodes;

        if(root.val==average) {
            totalNodesWithAverage++;
        }

        return new int[] {sum,nodes};
    }

    public int averageOfSubtree(TreeNode root) {
        totalNodesWithAverage = 0;
        getSumAndCount(root);
        return totalNodesWithAverage;
    }
}
