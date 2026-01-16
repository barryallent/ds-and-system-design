package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

//https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
public class SumRootToLeafNumbers {
    int sum;
    void sumNumbers(TreeNode root, int number) {
        if(root==null) {
            return;
        }
        number=number*10+root.val;

        if(root.left==null && root.right==null) {
            sum+=number;
        }

        sumNumbers(root.left,number);
        sumNumbers(root.right,number);
    }
    public int sumNumbers(TreeNode root) {
        sum=0;
        sumNumbers(root, 0);
        return sum;
    }
}
