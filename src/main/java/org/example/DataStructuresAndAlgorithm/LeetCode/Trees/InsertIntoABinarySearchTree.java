package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/description/
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);
        if(root==null) {
            return newNode;
        }

        //find where to insert the node, since current will become null so use previous
        TreeNode current = root;
        TreeNode previous = null;
        while(current!=null) {

            //move to left since value is smaller
            if(val<current.val) {
                previous = current;
                current=current.left;
            }

            //move to right
            else{
                previous = current;
                current=current.right;
            }
        }

        //previous is the node where we need to attach the newNode, compare with value and attach
        //accordinly to left or right side.
        if(val<previous.val) {
            previous.left=newNode;
        }
        else {
            previous.right=newNode;
        }

        return root;
    }
}
