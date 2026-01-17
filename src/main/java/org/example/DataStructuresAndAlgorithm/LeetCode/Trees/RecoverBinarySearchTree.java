package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/recover-binary-search-tree/description/
public class RecoverBinarySearchTree {
    TreeNode previous;
    TreeNode firstNode;
    TreeNode secondNode;
    void checkSwappedNodes(TreeNode root) {
        if(root==null) {
            return;
        }
        checkSwappedNodes(root.left);

        //1st time mismatch then mark firstnode and also secondnode mark as root
        //because there can be a case when there is no 2nd time mismatch
        //eg- 1,3,2,4
        if(previous!=null && previous.val>root.val && firstNode==null) {
            firstNode=previous;
            secondNode=root;
        }

        //2nd time mismatch mark second node
        //eg 1, 29, 8, 11, 17, 2, 41. here we have 2 time mismatch
        else if(previous!=null && previous.val>root.val && firstNode!=null) {
            secondNode=root;
        }
        previous=root;
        checkSwappedNodes(root.right);
    }
    public void recoverTree(TreeNode root) {
        previous=null;
        firstNode=null;
        secondNode=null;
        checkSwappedNodes(root);

        //swap the nodes, this condition should ideally always be true if we have 2 nodes swapped
        if(firstNode!=null && secondNode!=null) {
            int temp = firstNode.val;
            firstNode.val=secondNode.val;
            secondNode.val=temp;
        }
    }
}
