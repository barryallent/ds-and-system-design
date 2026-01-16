package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/description/
public class PathSumII {
    void pathSum(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if(root==null) {
            return;
        }
        currentPath.add(root.val);
        if(root.left==null && root.right==null && targetSum==root.val) {
            allPaths.add(new ArrayList<>(currentPath));
        }
        pathSum(root.left, targetSum-root.val, currentPath, allPaths);
        pathSum(root.right, targetSum-root.val, currentPath, allPaths);
        currentPath.remove(currentPath.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        pathSum(root, targetSum, new ArrayList<>(), allPaths);
        return allPaths;
    }
}
