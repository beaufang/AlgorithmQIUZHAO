package com.beau.leetcode.week2;

import com.beau.common.Node;

import java.text.NumberFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/21
 * 429 https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                Node node = deque.pollFirst();
                level.add(node.val);
                if (node.children != null) {
                    deque.addAll(node.children);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}
