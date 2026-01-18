package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    Map<Integer, Integer> inorderMap ;
    TreeNode buildTree(int[] preorder, int[] inorder, int inStart, int inEnd, int preStart, int preEnd) {
        if(inStart>inEnd || preStart>preEnd) {
            return null ;
        }

        TreeNode newNode = new TreeNode(preorder[preStart]);

        int inorderIndex = inorderMap.get(preorder[preStart]);

        int numsLeft = inorderIndex - inStart;

        newNode.left = buildTree(preorder, inorder, inStart, inorderIndex-1, preStart+1, preStart+numsLeft);
        newNode.right = buildTree(preorder, inorder, inorderIndex+1, inEnd, preStart+numsLeft+1, preEnd);

        return newNode;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++) {
            inorderMap.put(inorder[i],i);
        }

        int n = preorder.length;

        return buildTree(preorder, inorder, 0, n-1 , 0, n-1);
    }
}
