package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/distribute-coins-in-binary-tree/description/
public class DistributeCoinsInBinaryTree {
    //get total moves
    int getTotalMoves(TreeNode root, TreeNode parent) {
        if(root==null) {
            return 0;
        }

        int moves=0;

        //we need to do postorder here because a node can only correctly decide
        //how many coins to send to its parent after it has fully processed its children.
        moves+=getTotalMoves(root.left, root);
        moves+=getTotalMoves(root.right, root);

        //if we have less coins then we take from parent and update coins for parent
        if(root.val<=0 && parent!=null) {
            int coinsNeedToDistribute = 1 - root.val;
            parent.val-=coinsNeedToDistribute;
            moves+=coinsNeedToDistribute;
        }

        //if we have more coins then we give coin to parent and update coins for parent
        if(root.val>1 && parent!=null) {
            int coinsNeedToDistribute = root.val-1;
            moves+=coinsNeedToDistribute;
            parent.val+=coinsNeedToDistribute;
        }

        return moves;
    }
    public int distributeCoins(TreeNode root) {
        return getTotalMoves(root, null);
    }

    //optimal, no tree modification
//    int moves=0;
//    //get total moves
//    int getTotalMoves(TreeNode root) {
//        if(root==null) {
//            return 0;
//        }
//
//        //we need to do postorder here because a node can only correctly decide
//        //how many coins to send to its parent after it has fully processed its children.
//        int left = getTotalMoves(root.left);
//        int right = getTotalMoves(root.right);
//
//        // total moves needed at this node
//        //basically number of coins left and right tree has balance, can be positive if coins extra
//        //or negative if they need coin so we take absolute values or 0 if they have 1 coin
//        moves += Math.abs(left) + Math.abs(right);
//
//        //return excess coins to parent or take from it
//        int totalCoins = root.val + left + right;
//        int excessCoins = totalCoins - 1;
//        return excessCoins;
//    }
//    public int distributeCoins(TreeNode root) {
//        getTotalMoves(root);
//        return moves;
//    }
}
