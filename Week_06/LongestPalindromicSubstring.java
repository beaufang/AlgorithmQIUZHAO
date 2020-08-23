package com.beau.leetcode.week6;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * 5 ： https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 参考：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 */
public class LongestPalindromicSubstring {


    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        // 索引 i->j 之间的字符串是否为回文串
        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        int start = 0;
        // 注意填表顺序
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // case1: 只有一个字符肯定为回文
                // case2: i 和 j 相等，去掉 i 和 j 依然回文，s(i,j) 肯定回文
                // case3: i 和 j 相等，只有两个字符，肯定回文
                // 注意括号
                if (j - i == 0 || s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j - i == 1)) {
                    dp[i][j] = true;
                   if (j - i + 1 > maxLen) {
                       maxLen = j - i + 1;
                       start = i;
                   }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        // 索引 i->j 之间的字符串是否为回文串
        boolean[][] dp = new boolean[len][len];

        int maxLen = 1;
        int start = 0;
        // base case
        // 对角线表示只有一个字符，肯定是回文
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 注意填表顺序
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 只有三个字符
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome3(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        // dp[i][j] 表示 字符区间 i,j 之间是否是回文字符串
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (len == 1 || s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || len == 2)) {
                    dp[i][j] = true;
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    @Test
    public void test() {
        TestCase.assertEquals("cbc", longestPalindrome("accbc"));
//        TestCase.assertEquals("a",longestPalindrome("ac"));
    }
}
