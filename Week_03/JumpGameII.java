package com.beau.leetcode.week3;

/**
 * @author BeauFang
 * Date: 2020/8/1
 * 45 https://leetcode-cn.com/problems/jump-game-ii/
 */
public class JumpGameII {

    // 贪心，想象有一个矩形的框，每次在框中挑选最大值
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int max = 0;
        int step = 0;
        // 框的右边界
        int end = 0;
        // 注意区间
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            // 进入下一个框
            if (i == end) {
                end = max;
                step++;
            }
        }
        return step;
    }
}
