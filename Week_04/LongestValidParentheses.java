package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/6
 * 32 https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    /**
     * dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2]
     * dp[i] 表示以索引 i 结尾的串，有效括号的位数。
     * 如果 s[i] == '(' ， 则 dp[i] = 0; (右括号结尾无法形成有效括号)
     * dp 方程由三部分组成：
     * 1. 当前右括号和前面的左括号形成的有效括号 +2
     * 2. 当前右括号前面一位已经形成的有效括号 +dp[i - 1]
     * 3. 和当前右括号形成有效括号的左括号前面一位形成的有效括号 +dp[i - dp[i - 1] - 2]
     * 注意点：
     * 1. )))) 全是右括号的情况，在计算 dp 数组时，需要判断该右括号是否可以形成有效括号才能 +2 ,
     * 判断方式是 : 判断 s[index = i - dp[i - 1] - 1] 位置是否是左括号
     * 2. ()) ... ))())
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[1] = 0;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            if (s.charAt(i) == ')') {
                int index = i - dp[i - 1] - 1;
                if (index >= 0 && s.charAt(index) == '(') {
                    // 对应上面 dp 方程的第三部分
                    int leftIndex = i - dp[i - 1] - 2;
                    int leftCount = 0;
                    if (leftIndex >= 0) {
                        leftCount = dp[i - dp[i - 1] - 2];
                    }
                    dp[i] = 2 + dp[i - 1] + leftCount;
                    ans = Math.max(ans, dp[i]);
                }
            }
        }
        return ans;
    }

    @Test
    public void test() {
        TestCase.assertEquals(0, longestValidParentheses("(((("));
        TestCase.assertEquals(0, longestValidParentheses(")))"));
        TestCase.assertEquals(2, longestValidParentheses("()"));
        TestCase.assertEquals(2, longestValidParentheses("(()"));
        TestCase.assertEquals(2, longestValidParentheses("((()"));
        TestCase.assertEquals(2, longestValidParentheses("())))"));
    }
}
