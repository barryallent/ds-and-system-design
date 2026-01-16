package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) {
            return root;
        }

        if(p.val<root.val && q.val<root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        else if (p.val>root.val && q.val>root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        else {
            return root;
        }
    }
}
