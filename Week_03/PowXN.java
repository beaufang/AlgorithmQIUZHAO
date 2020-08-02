package com.beau.leetcode.week3;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/7/28
 * 50 https://leetcode-cn.com/problems/powx-n/
 */
public class PowXN {

    public double myPow(double x, int n) {
        // 防止 -n 越界
        long N = n;
        return N < 0 ? 1/myPowHelper(x, -N) : myPowHelper(x, N);
    }

    private double myPowHelper(double x, long n) {
        if (x == 1 || n == 0) {
            return 1;
        }
        double half = myPowHelper(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return x * half * half;
        }
    }
}
