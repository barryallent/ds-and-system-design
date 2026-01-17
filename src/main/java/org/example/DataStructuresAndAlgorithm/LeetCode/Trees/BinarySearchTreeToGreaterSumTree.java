package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/
public class BinarySearchTreeToGreaterSumTree {
    //global var because it needs to be shared accross recurive calls, next recursion calls
    //need to know what the previous currentSum was so we can't pass it in recursive function
    int currentSum;
    void inorderGreaterSumTree(TreeNode root) {
        if(root==null) {
            return;
        }

        inorderGreaterSumTree(root.right);
        currentSum+=root.val;
        root.val=currentSum;
        inorderGreaterSumTree(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        currentSum=0;
        inorderGreaterSumTree(root);
        return root;
    }
}
