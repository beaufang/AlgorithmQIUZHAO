package com.beau.leetcode.week2;

import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/22
 * 剑指 Offer 49. 丑数 https://leetcode-cn.com/problems/chou-shu-lcof/
 */
public class UglyNumber {

    // 动态规划
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        // 初始化，第一个丑数 1
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[p2] * 2, n3 = dp[p3] * 3, n5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (n2 == dp[i]) {
                p2++;
            }
            if (n3 == dp[i]) {
                p3++;
            }
            if (n5 == dp[i]) {
                p5++;
            }
        }
        return dp[n-1];
    }



}
