package com.beau.leetcode.week3;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/7/29
 * 55 https://leetcode-cn.com/problems/jump-game/
 */
public class JumpGame {

    // 贪心
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }
        // 记录最远可到达的距离
        int canReach = 0;
        for (int i = 0; i < len; i++) {
            if (i <= canReach) {
                canReach = Math.max(canReach, i + nums[i]);
                if (canReach >= len - 1) {
                    return true;
                }
            }
        }
        return false;
    }


    // 倒推法
    public boolean canJump2(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return true;
        }
        int i = len - 1, j = len - 2;
        while (j >= 0) {
            if (nums[j] >= (i - j)) {
                i = j;
            }
            j--;
        }
        return i == 0;
    }


    @Test
    public void test() {
        TestCase.assertTrue(canJump(new int[]{2, 3, 1, 1, 4}));
        TestCase.assertTrue(canJump(new int[]{2, 0, 0}));
        TestCase.assertFalse(canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
