package org.example.DataStructuresAndAlgorithm.LeetCode.DynamicProgramming;

//https://leetcode.com/problems/binary-tree-cameras/description/
public class BinaryTreeCameras {
    static final int UNCOVERED = 0;
    static final int HAS_CAMERA = 1;
    static final int COVERED = 2;

    int camerasNeeded = 0;

    //here this is a greedy approach, we will start from bottom using post order traversal
    //each node can return 3 states
    //"Covered" : Covered by children (we start from bottom so we cant check covered by parent)
    //"Uncovered": not covered by children
    //"Has Camera": this node has camera
    int getMinCamerasNeeded(TreeNode root) {

        //null node is covered
        if (root == null) {
            return COVERED;
        }

        int left = getMinCamerasNeeded(root.left);
        int right = getMinCamerasNeeded(root.right);

        //if either of the child is uncovered then we need to place a camera on this node
        if (left == UNCOVERED || right == UNCOVERED) {
            camerasNeeded++;
            return HAS_CAMERA;
        }

        //if either of children has a camera then they can cover this node
        if (left == HAS_CAMERA || right == HAS_CAMERA ) {
            return COVERED;
        }

        //if none of the children has camera but both are covered so this node will be uncovered
        //and request parent for a camera in next step
        return UNCOVERED;
    }

    public int minCameraCover(TreeNode root) {

        //check if root node also is uncovered state then increase 1 camera
        camerasNeeded = getMinCamerasNeeded(root) == UNCOVERED ? camerasNeeded + 1 : camerasNeeded;
        return camerasNeeded;
    }
}
