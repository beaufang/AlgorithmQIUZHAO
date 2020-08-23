package com.beau.leetcode.week6;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/22
 * 115 https://leetcode-cn.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        TestCase.assertEquals(3, numDistinct("rabbbit", "rabbit"));
        TestCase.assertEquals(5, numDistinct("babgbag","bag"));
    }
}
