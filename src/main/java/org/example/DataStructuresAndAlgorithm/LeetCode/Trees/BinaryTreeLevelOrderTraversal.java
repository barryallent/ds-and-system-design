package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-level-order-traversal/description/
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> levelOrder(TreeNode root, int level, List<List<Integer>> levelOrderList) {
        if (root == null) {
            return levelOrderList;
        }

        if (levelOrderList.size() == level) {
            levelOrderList.add(new ArrayList<>());
        }

        levelOrderList.get(level).add(root.val);

        levelOrder(root.left, level + 1, levelOrderList);
        levelOrder(root.right, level + 1, levelOrderList);

        return levelOrderList;

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrder(root, 0, new ArrayList<>());
    }
}
