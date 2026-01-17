package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/deepest-leaves-sum/description/
public class DeepestLeavesSum {
    //we need global var because each recursion depend on these global values to check maxDepth and
    //add to sum
    int maxDepth;
    int sum;

    //idea is to go to maxDepth and add to sum, if we get a greater maxDepth then sum is reset
    void deepestLeavesSum(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        //got a greater maxDepth so reset sum and update maxDepth
        if (level > maxDepth) {
            maxDepth = level;
            sum = root.val;
        }
        //got another node at same maxDepth so add this to sum
        else if (level == maxDepth) {
            sum += root.val;
        }

        deepestLeavesSum(root.left, level + 1);
        deepestLeavesSum(root.right, level + 1);
    }

    public int deepestLeavesSum(TreeNode root) {
        maxDepth = -1;
        sum = 0;
        deepestLeavesSum(root, 0);
        return sum;
    }
}
