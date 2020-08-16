package com.beau.leetcode.week5;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/11
 * 231 https://leetcode-cn.com/problems/power-of-two/
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        // 有且仅有一个 1
        return n > 0 && (n & (n - 1)) == 0;
    }

    @Test
    public void test() {
        TestCase.assertTrue(isPowerOfTwo(4));
        TestCase.assertFalse(isPowerOfTwo(7));
        TestCase.assertFalse(isPowerOfTwo(6));
    }
}
