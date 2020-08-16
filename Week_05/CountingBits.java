package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/14
 * 338 https://leetcode-cn.com/problems/counting-bits/
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i & (i - 1)] + 1;
        }
        return dp;
    }
}
