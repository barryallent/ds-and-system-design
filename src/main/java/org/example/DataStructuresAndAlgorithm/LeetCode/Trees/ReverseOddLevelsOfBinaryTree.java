package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/
public class ReverseOddLevelsOfBinaryTree {
    public TreeNode reverseOddLevels(TreeNode root) {

        Queue<TreeNode> q1 = new LinkedList<>();

        if (root != null)
            q1.add(root);

        int level = 0;

        while (!q1.isEmpty()) {

            int size = q1.size();

            List<TreeNode> levelNodes = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode current = q1.poll();

                if (level % 2 != 0)
                    levelNodes.add(current);

                if (current.left != null) {
                    q1.add(current.left);
                }

                if (current.right != null) {
                    q1.add(current.right);
                }

            }

            //odd level so need to reverse without using any extra space
            if (level % 2 != 0) {
                int n = levelNodes.size();
                int l=0;
                int r=n-1;
                //loop to swap nodes
                while (l<r) {
                    //just swap values from start and end
                    int temp = levelNodes.get(l).val;
                    levelNodes.get(l).val = levelNodes.get(r).val;
                    levelNodes.get(r).val = temp;
                    r--;
                    l++;
                }
            }
            level++;
        }
        return root;
    }
}
