package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/delete-leaves-with-a-given-value/description/
public class DeleteLeavesWithAGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root==null) {
            return root;
        }
        root.left=removeLeafNodes(root.left, target);
        root.right=removeLeafNodes(root.right,target);

        if(root.left==null && root.right==null && root.val==target) {
            return null;
        }
        return root;

    }
}
