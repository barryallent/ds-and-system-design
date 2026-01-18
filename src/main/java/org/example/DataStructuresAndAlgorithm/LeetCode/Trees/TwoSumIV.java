package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.Stack;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
public class TwoSumIV {
    public boolean findTarget(TreeNode root, int k) {
        BSTIterator left = new BSTIterator(root, false);
        BSTIterator right = new BSTIterator(root, true);

        int i = left.next();
        int j = right.next();

        while(i<j) {
            int sum = i+j;
            if(sum<k) {
                i=left.next();
            }
            else if(sum>k) {
                j=right.next();
            }
            else {
                return true;
            }
        }
        return false;
    }
}

class BSTIterator {

    Stack<TreeNode> s1 = new Stack<>();
    TreeNode current;
    Boolean reverse;

    public BSTIterator(TreeNode root, Boolean reverse) {
        current = root;
        this.reverse = reverse;
    }

    public int next() {
        while(current!=null) {
            s1.add(current);
            current= !reverse ? current.left:current.right;
        }
        TreeNode topElement = s1.pop();
        current= !reverse ? topElement.right:topElement.left;
        return topElement.val;
    }

    public boolean hasNext() {
        return current!=null || !s1.isEmpty();
    }
}
