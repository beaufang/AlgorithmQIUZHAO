package com.beau.leetcode.week2;

import com.beau.common.Node;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/20
 * 590 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class NaryTreePostorderTraversal {

    // 迭代解法
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ans.addFirst(node.val);
            for (Node n : node.children) {
                stack.addLast(n);
            }
        }
        return ans;
    }


    // 递归解法
    public List<Integer> postorder1(Node root) {
        List<Integer> ans = new LinkedList<>();
        postOrderRecursive(ans, root);
        return ans;
    }

    private void postOrderRecursive(List<Integer> result, Node root) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (Node child : root.children) {
                postOrderRecursive(result, child);
            }
        }
        result.add(root.val);
    }

}
