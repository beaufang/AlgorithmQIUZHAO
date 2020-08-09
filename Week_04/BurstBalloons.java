package com.beau.leetcode.week4;

/**
 * @author BeauFang
 * Date: 2020/8/9
 * 312 https://leetcode-cn.com/problems/burst-balloons/
 * 参考 ： https://mp.weixin.qq.com/s/I0yo0XZamm-jMpG-_B3G8g
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] points = new int[n + 2];
        System.arraycopy(nums, 0, points, 1, n);
        points[0] = 1;
        points[n + 1] = 1;
        // dp[i][j] 表示戳破区间 (i,j) 的气球所获得的最大硬币数量, k 表示最后被戳破的气球
        // dp[i][j] = max(dp[i][k] + dp[k][j] + points[i] * points[k] * points[j])
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n + 1; i >= 0; i--) {
            for (int j = i + 1; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]);
                }
            }
        }
        return dp[0][n + 1];
    }

}
