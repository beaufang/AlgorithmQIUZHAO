package com.beau.leetcode.week2;

import com.beau.common.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/20
 * 589 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class NaryTreePreorderTraversal {


    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.addLast(node.val);
            List<Node> children = node.children;
            Collections.reverse(children);
            for (Node child : children) {
                stack.addLast(child);
            }
        }
        return ans;
    }


    // 递归解法
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder1(Node root) {
        if (root == null) {
            return ans;
        }
        ans.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                preorder1(node);
            }
        }
        return ans;
    }

}
