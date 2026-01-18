package org.example.DataStructuresAndAlgorithm.LeetCode.Trees;

public class SerializeAndDeserializeBinaryTree {
    //pre order to serialize and store preorder result in sb
    void serializeHelper(TreeNode root, StringBuilder sb) {
        if(root==null) {
            sb.append("# ");
            return;
        }
        sb.append(root.val+" ");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder preorder = new StringBuilder();
        serializeHelper(root, preorder);
        return preorder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] newData = data.split(" ");
        return deserializeHelper(newData, new int[]{0});
    }

    //preorder to deseriaze the same data that means we are following same sequence
    TreeNode deserializeHelper(String[] data, int[] i) {
        if(i[0]>=data.length || data[i[0]].equals("#")) {
            i[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(data[i[0]]));
        i[0]++;
        root.left = deserializeHelper(data, i);
        root.right = deserializeHelper(data, i);
        return root;
    }
}
