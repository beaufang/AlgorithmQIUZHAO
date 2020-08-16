package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/12
 * 70 https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
