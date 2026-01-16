package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
public class KthSmallestElementInABST {
    int count;
    int kthSmallesValue;

    void getKthSmallest(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        getKthSmallest(root.left, k);
        count++;
        if (count == k) {
            kthSmallesValue = root.val;
        }
        getKthSmallest(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        kthSmallesValue = 0;
        getKthSmallest(root, k);
        return kthSmallesValue;
    }
}
