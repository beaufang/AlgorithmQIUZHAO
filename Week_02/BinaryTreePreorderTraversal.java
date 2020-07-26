package com.beau.leetcode.week2;

import com.beau.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/21
 * 144 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class BinaryTreePreorderTraversal {





    // 迭代解法
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            ans.add(node.val);
            if (node.right != null) {
                stack.addLast(node.right);
            }
            if (node.left != null) {
                stack.addLast(node.left);
            }
        }
        return ans;
    }

    // 递归
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);
        return ans;
    }
}
