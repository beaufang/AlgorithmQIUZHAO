package com.beau.leetcode;

// 66
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + 1;
            digits[i] = digits[i] % 10;
            // 不需要进位
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 处理 999 的情况
        // 数组默认初始化为 0
        digits = new int[digits.length + 1 ];
        digits[0] = 1;
        return digits;
    }
}
