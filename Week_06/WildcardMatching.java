package com.beau.leetcode.week6;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/19
 * 44 https://leetcode-cn.com/problems/wildcard-matching/
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        // dp[i][j] 表示 s.substring(0, i) 和 p.subString(0, j) 是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 当 s 串为空时，p 串必须全部是 * 才能匹配
        for (int i = 1; i <= n; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        TestCase.assertTrue(isMatch("aa", "*"));
    }
}
