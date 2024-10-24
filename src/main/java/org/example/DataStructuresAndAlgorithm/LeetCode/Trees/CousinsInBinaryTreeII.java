package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/cousins-in-binary-tree-ii/description/
public class CousinsInBinaryTreeII {
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);

        //find the level sum for each level
        List<Integer> levelSum = new ArrayList<>();

        while (!q1.isEmpty()) {
            int size = q1.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode topElement = q1.poll();
                sum += topElement.val;
                if (topElement.left != null) {
                    q1.offer(topElement.left);
                }
                if (topElement.right != null) {
                    q1.offer(topElement.right);
                }
            }
            levelSum.add(sum);
        }


        //for each node assign value as levelsum-sum of siblings
        q1 = new LinkedList<>();
        q1.offer(root);

        int level = 0;

        while (!q1.isEmpty()) {
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode topElement = q1.poll();

                //get left and right sum
                int leftSum = topElement.left != null ? topElement.left.val : 0;
                int rightSum = topElement.right != null ? topElement.right.val : 0;

                //assign sum as next level sum - siblings sum
                if (topElement.left != null) {
                    topElement.left.val = levelSum.get(level+1) - leftSum - rightSum;
                    q1.offer(topElement.left);
                }
                if (topElement.right != null) {
                    topElement.right.val = levelSum.get(level+1) - leftSum - rightSum;
                    q1.offer(topElement.right);
                }

            }
            level++;
        }
        root.val = 0;
        return root;

    }
}
