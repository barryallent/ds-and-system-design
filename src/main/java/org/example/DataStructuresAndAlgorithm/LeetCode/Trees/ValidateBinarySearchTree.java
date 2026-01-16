package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/validate-binary-search-tree/description/
public class ValidateBinarySearchTree {
    Integer previous;
    boolean isValidBST2(TreeNode root) {
        if(root==null) {
            return true;
        }

        boolean leftCheck=isValidBST2(root.left);
        if(previous!=null && root.val<=previous) {
            return false;
        }
        previous=root.val;
        boolean rightCheck=isValidBST2(root.right);

        return leftCheck && rightCheck;
    }
    public boolean isValidBST(TreeNode root) {
        previous=null;
        return isValidBST2(root);
    }
}
