package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

//https://leetcode.com/problems/delete-nodes-and-return-forest/description/
public class DeleteNodesAndReturnForest {
    Map<TreeNode, TreeNode> parentTrack = new HashMap<>();

    //taking it as set because we need to check this before putting a node in final answer
    Set<TreeNode> nodesForRemoval = new HashSet<>();

    Set<Integer> nodeValuesToDelete = new HashSet<>();

    //get parents for all nodes
    void markAllNodesParent(TreeNode root, TreeNode parent) {
        if(root==null) {
            return;
        }
        parentTrack.put(root,parent);
        markAllNodesParent(root.left, root);
        markAllNodesParent(root.right,root);
    }

    //traverse and save all the nodes to delete, we can't remove them in this recursion because
    //we need to traverse the full tree
    void traverseAndSaveNodesForRemoval(TreeNode root) {
        if(root==null) {
            return;
        }
        if(nodeValuesToDelete.contains(root.val)) {
            nodesForRemoval.add(root);
        }
        traverseAndSaveNodesForRemoval(root.left);
        traverseAndSaveNodesForRemoval(root.right);
    }

    //idea of to traverse all the nodes and save all the nodes to delete so that we can delete
    //them later we will use set to check if nodes needs to be deleted
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        //put all nodes in set.
        for(int i:to_delete) {
            nodeValuesToDelete.add(i);
        }

        //traverse and save all nodes to delete
        traverseAndSaveNodesForRemoval(root);

        //mark parents of all nodes, will be used to delete the node
        markAllNodesParent(root,null);

        List<TreeNode> finalTreeNodes = new ArrayList<>();

        //need to add root to final answer if its not in nodes to be deleted
        boolean isRootToBeDeleted=false;

        //delete the nodes
        for(TreeNode node:nodesForRemoval) {

            //if node is also to be deleted then we won't add it to final list of nodes
            if(node==root) {
                isRootToBeDeleted=true;
            }

            //before delete we need to seperate its children and put in answer
            //also check if nodes are present in to be deleted, because node children
            //can also be in tobedeleted list
            if(node.left!=null && !nodesForRemoval.contains(node.left)) {
                finalTreeNodes.add(node.left);
            }
            if(node.right!=null && !nodesForRemoval.contains(node.right)) {
                finalTreeNodes.add(node.right);
            }

            //now to delete the node we need to go to parent and make its child as null
            //but we don't know its which children so checking both left and right
            //it can be either left or right because all values are distinct
            TreeNode parent = parentTrack.get(node);

            if(parent==null) {
                continue;
            }

            //if its right children then mark it as null
            if(parent.left!=null && parent.left.val==node.val) {
                parent.left=null;
            }

            //if its right children then mark it as null
            else if(parent.right!=null && parent.right.val==node.val) {
                parent.right=null;
            }
        }

        //if node is not to be deleted then add it in final remaining nodes
        if(!isRootToBeDeleted) {
            finalTreeNodes.add(root);
        }

        return finalTreeNodes;
    }
}
