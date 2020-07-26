package com.beau.leetcode.week2;

import com.beau.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author BeauFang
 * Date: 2020/7/25
 * 297 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * 参考：https://www.bilibili.com/video/BV1KD4y1Q7F8
 */
public class SerializeAndDeserializeBinaryTree {

    // 层序遍历
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null");
            } else {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append("]");
        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.substring(1, data.length() - 1).split(",");
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = getNode(arr[0]);
        Queue<TreeNode> parents = new LinkedList<>();
        parents.add(root);
        boolean isLeft = true;
        for (int i = 1; i < arr.length; i++) {
            TreeNode node = getNode(arr[i]);
            TreeNode parent = parents.peek();
            if (isLeft) {
                parent.left = node;
            } else {
                parent.right = node;
            }
            isLeft = !isLeft;
            if (isLeft) {
                parents.poll();
            }
            if (node != null) {
                parents.add(node);
            }
        }
        return root;
    }

    private TreeNode getNode(String str) {
        return "null".equals(str) ? null : new TreeNode(Integer.parseInt(str));
    }

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree solution = new SerializeAndDeserializeBinaryTree();
        TreeNode root = solution.deserialize("[1,2,3,null,null,4,5]");
        System.out.println(root.val);
        String str = solution.serialize(root);
        System.out.println(str);
    }
}
