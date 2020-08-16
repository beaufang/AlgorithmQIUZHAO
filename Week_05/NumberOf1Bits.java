package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/11
 * 191 https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            n = n & (n - 1);
            ans++;
        }
        return ans;
    }
}
