package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        if(root!=null) {
            q1.add(root);
        }

        List<List<Integer>> zigZagOrder = new ArrayList<>();

        boolean leftToRight=true;

        while(!q1.isEmpty()) {
            int size = q1.size();
            //using Deque to avoid reversing each list
            Deque<Integer> levelElements = new ArrayDeque<>();
            for(int i=0;i<size;i++) {
                TreeNode current = q1.poll();

                //add at last then only it will be left to right order
                if(leftToRight) {
                    levelElements.addLast(current.val);
                }
                else {
                    levelElements.addFirst(current.val);
                }
                if(current.left!=null) {
                    q1.add(current.left);
                }
                if(current.right!=null) {
                    q1.add(current.right);
                }
            }

            List<Integer> levelElementsList = new ArrayList<>();
            zigZagOrder.add(new ArrayList<>(levelElements));
            leftToRight=!leftToRight;

        }

        return zigZagOrder;
    }
}
