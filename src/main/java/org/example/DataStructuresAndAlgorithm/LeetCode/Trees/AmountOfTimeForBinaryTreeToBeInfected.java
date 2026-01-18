package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

//https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/
public class AmountOfTimeForBinaryTreeToBeInfected {
    Map<TreeNode, TreeNode> parentMap;
    TreeNode startingNode;

    void markParent(TreeNode root, TreeNode parent, int start) {
        if (root == null) {
            return;
        }
        if(root.val==start) {
            startingNode=root;
        }
        parentMap.put(root, parent);
        markParent(root.left, root, start);
        markParent(root.right, root, start);

    }

    public int amountOfTime(TreeNode root, int start) {
        parentMap = new HashMap<>();
        startingNode = null;
        markParent(root, null, start);

        Queue<TreeNode> q1 = new LinkedList<>();
        Set<TreeNode> infectedNodes = new HashSet<>();

        if (startingNode != null) {
            q1.add(startingNode);
            infectedNodes.add(startingNode);
        }

        int time = 0;

        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode current = q1.poll();
                if (current.left != null && !infectedNodes.contains(current.left)) {
                    q1.add(current.left);
                    infectedNodes.add(current.left);
                }
                if (current.right != null && !infectedNodes.contains(current.right)) {
                    q1.add(current.right);
                    infectedNodes.add(current.right);
                }
                if (parentMap.get(current) != null && !infectedNodes.contains(parentMap.get(current))) {
                    q1.add(parentMap.get(current));
                    infectedNodes.add(parentMap.get(current));
                }
            }
            time++;
        }
        return time-1;
    }
}
