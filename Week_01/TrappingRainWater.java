package com.beau.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author BeauFang
 * Date: 2020/7/17
 * 42: https://leetcode-cn.com/problems/trapping-rain-water/?utm_source=LCUS&utm_medium=ip_redirect_q_uns&utm_campaign=transfer2china
 */
public class TrappingRainWater {


    // 双指针
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        int l = 0, r = height.length - 1;
        int maxL = height[0], maxR = height[height.length - 1];
        while (l < r) {
            if (height[r] > height[l]) {
                ans += maxL - height[l];
                maxL = Math.max(maxL, height[++l]);
            } else {
                ans += maxR - height[r];
                maxR = Math.max(maxR, height[--r]);
            }
        }

        return ans;
    }

    // 单调栈
    public int trap2(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int top = height[stack.pollLast()];
                if (stack.isEmpty()) {
                    break;
                }
                int w = i - stack.peekLast() - 1;
                int h = Math.min(height[stack.peekLast()], height[i]);
                ans += w * (h - top);
            }
            stack.addLast(i);
        }
        return ans;
    }

    // 暴力法， 计算每个柱子上面可残留的水量
    public int trap1(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int ans = 0;
        int len = height.length;
        int maxLeft = height[0];
        for (int i = 1; i < len - 1; i++) {
            int maxRight = 0;
            // search right,
            // 从 i 开始遍历，可以避免找不到高于当前柱子的柱子，出现负值的情况
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            // 左侧柱子最大高度
            maxLeft = Math.max(maxLeft, height[i]);
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }


    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
//        int trap = trappingRainWater.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int trap = trappingRainWater.trap(new int[]{2 , 0, 2});
        System.out.println(trap);
    }
}