package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
public class SumOfNodesWithEvenValuedGrandparent {
    int getSumEvenGrandparent(TreeNode root, TreeNode parent, TreeNode granParent) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (granParent != null && granParent.val % 2 == 0) {
            sum += root.val;
        }

        return sum + getSumEvenGrandparent(root.left, root, parent) +
                getSumEvenGrandparent(root.right, root, parent);
    }

    public int sumEvenGrandparent(TreeNode root) {

        return getSumEvenGrandparent(root, null, null);

    }
}
