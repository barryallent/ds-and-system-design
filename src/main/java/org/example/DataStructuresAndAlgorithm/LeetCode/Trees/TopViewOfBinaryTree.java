package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TopViewOfBinaryTree {
    class Pair {
        int nodeValue;
        int level;
        Pair(int nodeValue, int level) {
            this.nodeValue=nodeValue;
            this.level=level;
        }
    }
    Map<Integer,Pair> topViewMap = new TreeMap<>();
    void getTopView(TreeNode root, int x, int level) {
        if(root==null) {
            return;
        }

        if(!topViewMap.containsKey(x) || topViewMap.get(x).level>level) {
            topViewMap.put(x, new Pair(root.val,level));
        }
        getTopView(root.left, x-1, level+1);
        getTopView(root.right, x+1, level+1);
    }
    public ArrayList<Integer> topView(TreeNode root) {
        // code here
        topViewMap = new TreeMap<>();

        getTopView(root, 0, 0);
        ArrayList<Integer> topView = new ArrayList<>();
        //convert map to list
        for(Map.Entry<Integer,Pair> entry:topViewMap.entrySet()) {
            topView.add(entry.getValue().nodeValue);
        }
        return topView;
    }
}
