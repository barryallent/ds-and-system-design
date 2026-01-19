package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.*;

class Directions {
    TreeNode node;
    StringBuilder path;
    Directions(TreeNode node, StringBuilder path) {
        this.node=node;
        this.path=path;
    }
}

public class StepByStepDirectionsFromABinaryTreeNodeToAnother {
    TreeNode startNode;
    TreeNode destNode;
    Map<TreeNode, TreeNode> parentMap;

    //get the start and end nodes address and also calculate parents of each node
    void getNodeAddresses(TreeNode root, int startValue, int destValue, TreeNode parent) {
        if(root==null) {
            return;
        }
        if(root.val==startValue) {
            startNode=root;
        }
        else if(root.val==destValue) {
            destNode=root;
        }
        parentMap.put(root, parent);
        getNodeAddresses(root.left, startValue, destValue, root);
        getNodeAddresses(root.right, startValue, destValue, root);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        startNode = null;
        destNode = null;
        parentMap = new HashMap<>();

        getNodeAddresses(root, startValue, destValue, null);

        Queue<Directions> q1 = new LinkedList<>();

        //visited is important for these questions where we can come back again to the nodes
        Set<TreeNode> visitedNodes = new HashSet<>();

        //since this is shorted path question
        //idea is to start BFS from starting node with storing paths as well
        if(startNode!=null) {
            q1.add(new Directions(startNode, new StringBuilder()));
            visitedNodes.add(startNode);
        }

        while(!q1.isEmpty()) {
            int size = q1.size();
            for(int i=0;i<size;i++) {
                Directions current = q1.poll();
                TreeNode currentNode = current.node;

                StringBuilder currentPath = current.path;

                //reached end so return path till now
                if(currentNode==destNode) {
                    return currentPath.toString();
                }

                //at each node we dont modify the existing path but create a new path and add to queue
                //so no backtracking kind of thing is needed
                if(currentNode.left!=null && !visitedNodes.contains(currentNode.left)) {
                    StringBuilder newPath = new StringBuilder(currentPath);
                    newPath.append("L");
                    q1.add(new Directions(currentNode.left,newPath ));
                    visitedNodes.add(currentNode.left);
                }
                if(currentNode.right!=null && !visitedNodes.contains(currentNode.right)) {
                    StringBuilder newPath = new StringBuilder(currentPath);
                    newPath.append("R");
                    q1.add(new Directions(currentNode.right,newPath ));
                    visitedNodes.add(currentNode.right);
                }
                if(parentMap.get(currentNode)!=null && !visitedNodes.contains(parentMap.get(currentNode))) {
                    StringBuilder newPath = new StringBuilder(currentPath);
                    newPath.append("U");
                    q1.add(new Directions(parentMap.get(currentNode),newPath ));
                    visitedNodes.add(parentMap.get(currentNode));
                }
            }
        }

        //ideally this should never reach here as we will always have start and end node in tree
        //so we will definately reach from start to end inside BFS
        return "";

    }
}
