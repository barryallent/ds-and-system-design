package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> s1 = new Stack<>();
    TreeNode current;

    public BinarySearchTreeIterator(TreeNode root) {
        current = root;
    }

    public int next() {
        while(current!=null) {
            s1.add(current);
            current=current.left;
        }
        TreeNode topElement = s1.pop();
        current=topElement.right;
        return topElement.val;
    }

    public boolean hasNext() {
        return current!=null || !s1.isEmpty();
    }
}
