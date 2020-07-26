package com.beau.leetcode.week2;

import com.beau.common.TreeNode;

/**
 * @author BeauFang
 * Date: 2020/7/23
 * 236 https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorOfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 当 left 和 right 任意一个 为 null 的时候，说明其中一个本身就是祖先
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
