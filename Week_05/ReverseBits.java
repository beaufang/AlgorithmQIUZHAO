package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/11
 * 190 https://leetcode-cn.com/problems/reverse-bits/
 * 参考 ： https://leetcode-cn.com/problems/reverse-bits/solution/dian-dao-er-jin-zhi-wei-by-leetcode/
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            // 想象成一个队列
            ans = (ans << 1) + (n & 1);
            n = n >> 1;
        }
        return ans;
    }
}
