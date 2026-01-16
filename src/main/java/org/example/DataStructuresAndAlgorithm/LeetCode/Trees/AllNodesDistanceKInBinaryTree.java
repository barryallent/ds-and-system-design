package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
public class AllNodesDistanceKInBinaryTree {
    Map<TreeNode,TreeNode> parentMap;

    //gets parents for all nodes and stores in parentMap
    void markParent(TreeNode root, TreeNode parent) {
        if(root==null) {
            return;
        }

        parentMap.put(root,parent);
        markParent(root.left, root);
        markParent(root.right, root);

    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parentMap = new HashMap<>();

        //get parents
        markParent(root,null);

        Queue<TreeNode> q1 = new LinkedList<>();

        int distance=0;

        List<Integer> kDistanceNodes = new ArrayList<>();

        Set<TreeNode> visited = new HashSet<>();

        if(target!=null) {
            q1.add(target);
            visited.add(target);
        }


        //bfs from target node
        while(!q1.isEmpty()) {

            int size = q1.size();

            for(int i=0;i<size;i++) {

                TreeNode current = q1.poll();

                //distance is k so add all kDistanceNodes
                if(distance==k) {
                    kDistanceNodes.add(current.val);
                }

                //add neightbours if they are present and not visited already
                if(current.left!=null && !visited.contains(current.left)) {
                    q1.add(current.left);
                    visited.add(current.left);
                }
                if(current.right!=null && !visited.contains(current.right)) {
                    q1.add(current.right);
                    visited.add(current.right);
                }
                if(parentMap.get(current)!=null && !visited.contains(parentMap.get(current))) {
                    q1.add(parentMap.get(current));
                    visited.add(parentMap.get(current));
                }
            }

            //distance is k so return all kDistanceNodes
            if(distance==k) {
                return kDistanceNodes;
            }
            distance++;

        }

        return kDistanceNodes;
    }
}
