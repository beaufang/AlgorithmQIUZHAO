package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/6
 * 72 https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {

    /**
     * 先从递归的角度会比较好分析。
     * dp[i][j] 定义为 word1[0,i] 转换到 word2[0,j]的最小编辑距离。
     *      1. 如果 word[i] == word[j]，则 dp[i][j] = dp[i - 1][j - 1];
     *      2. 如果 word[i] != word[j]，对 word1 分别执行增删替操作：
     *          1. 增： dp[i][j] = 1 + dp[i][j - 1] (增加 word1 一位，相当于删除 word2 一位（消除掉了最后一位）)
     *          2. 删： dp[i][j] = 1 + dp[i-1][j]
     *          3. 替： dp[i][j] = 1 + dp[i-1][j-1]
     * 注意事项：
     *      1. dp 数组初始长度应为 dp[word1.length()+1][word2.length()+1]。因为第一行和第一列都表示另外一个字符串为空
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        // dp[0][0] 表示空串
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        TestCase.assertEquals(3, minDistance("horse", "ros"));
        TestCase.assertEquals(5, minDistance("intention", "execution"));
        TestCase.assertEquals(3, minDistance("aaa", ""));
        TestCase.assertEquals(2, minDistance("aaa", "a"));
    }
}
