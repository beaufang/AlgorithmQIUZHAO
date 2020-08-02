package com.beau.leetcode.week3;

/**
 * @author BeauFang
 * Date: 2020/7/26
 * 169 https://leetcode-cn.com/problems/majority-element/
 */
public class MajorityElement {

    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
