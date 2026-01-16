package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/cousins-in-binary-tree/description/
public class CousinsInBinaryTree {
    //global vars to track parent and level for x and y nodes
    int xLevel;
    TreeNode xParent;
    int yLevel;
    TreeNode yParent;

    void isCousins(TreeNode root, int x, int y, int level, TreeNode parent) {
        if(root==null){
            return;
        }

        //recusively check left subtree and increase level and parent becomes root for root.left
        isCousins(root.left, x, y, level+1, root);

        //x is found so store level and parent
        if(root.val==x) {
            xLevel=level;
            xParent=parent;
        }

        //y is found so store level and parent
        if(root.val==y) {
            yLevel=level;
            yParent=parent;
        }

        //recusively check right subtree and increase level and parent becomes root for root.right
        isCousins(root.right, x, y, level+1, root);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        xLevel=-1;
        xParent=null;
        yLevel=-1;
        yParent=null;

        isCousins(root, x, y, 0, null);

        //check cousin condition i.e. nodes level are same but parents are not equal
        return (xLevel==yLevel) && xParent!=yParent;

    }
}
