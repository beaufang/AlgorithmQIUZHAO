package com.beau.leetcode.week2;

import com.beau.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/7/23
 * 105 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        // 前序遍历和中序遍历的节点数必须相等
        if (preLen != inLen) {
            return null;
        }
        // 记录中序遍历节点索引信息
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preLen - 1, inorder, 0, inLen - 1, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int preL, int preR,
                                    int[] inorder, int inL, int  inR, Map<Integer, Integer> map) {
        if (preL > preR || inL > inR) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[preL]);
        // 获取 root 节点在中序遍历的索引
        int pIndex = map.get(node.val);
        // 前序遍历：根 [左子树] [右子树]； 中序遍历 [左子树] 根 [右子树]
        node.left = buildTreeHelper(preorder, preL + 1, preL + pIndex - inL,
                inorder, inL, pIndex - 1, map);
        node.right = buildTreeHelper(preorder, preL + pIndex - inL + 1, preR,
                inorder, pIndex + 1, inR, map);
        return node;
    }
}
