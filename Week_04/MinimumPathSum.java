package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/3
 * 64 https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = Arrays.copyOf(grid, grid.length);
        // 初始化状态
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] += dp[i - 1][0];
        }
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] += dp[0][i - 1];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] += Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    @Test
    public void test() {
        TestCase.assertEquals(6, minPathSum(new int[][] {{1,2,5},{3,2,1}}));
    }
}
