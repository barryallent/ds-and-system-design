package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
public class VerticalOrderTraversalOfABinaryTree {
    Map<Integer, Map<Integer, List<Integer>>> verticalOrderMap;

    void verticalTraversal(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }
        if (!verticalOrderMap.containsKey(x)) {
            verticalOrderMap.put(x, new TreeMap<>());
        }
        Map<Integer, List<Integer>> temp = verticalOrderMap.get(x);
        if (!temp.containsKey(y)) {
            temp.put(y, new ArrayList<>());
        }
        temp.get(y).add(root.val);

        verticalTraversal(root.left, x - 1, y + 1);
        verticalTraversal(root.right, x + 1, y + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        verticalOrderMap = new TreeMap<>();
        verticalTraversal(root, 0, 0);

        List<List<Integer>> verticalOrderList = new ArrayList<>();

        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : verticalOrderMap.entrySet()) {

            int x = entry.getKey();
            List<Integer> temp = new ArrayList<>();
            for (Map.Entry<Integer, List<Integer>> entry2 : entry.getValue().entrySet()) {
                int y = entry2.getKey();
                List<Integer> temp2 = entry2.getValue();
                Collections.sort(temp2);
                for (int i : temp2) {
                    temp.add(i);
                }
            }
            verticalOrderList.add(temp);

        }
        return verticalOrderList;
    }
}
