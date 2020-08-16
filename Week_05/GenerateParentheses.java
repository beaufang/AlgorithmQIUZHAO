package com.beau.leetcode.week5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/13
 * 22 https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(0, 0, n, new StringBuilder(), ans);
        return ans;
    }

    private void helper(int left, int right, int n, StringBuilder sb, List<String> ans) {
        if (left == n && right == n) {
            ans.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            helper(left + 1, right, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
        if (right < n && right < left) {
            sb.append(")");
            helper(left, right + 1, n, sb, ans);
            sb.setLength(sb.length() - 1);
        }
    }
}
