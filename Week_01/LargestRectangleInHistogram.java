package com.beau.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author BeauFang
 * Date: 2020/7/16
 * 84
 */
public class LargestRectangleInHistogram {

    // 单调栈+哨兵
    @SuppressWarnings("all")
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        // 设置哨兵, 数组首位添加 0
        newHeights[0] = 0;
        newHeights[len + 1] = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int maxArea = 0;
        for (int i = 1; i < newHeights.length; i++) {
            while (newHeights[i] < newHeights[stack.peekLast()]) {
                /* 注意这里计算高度和宽度：
                    计算高度时，使用的是 poll 方法，让当前柱子出栈
                    计算宽度时，使用的时 peek 方法，取出的是当前出栈柱子左侧最近的小于当前柱子高度的柱子的索引
                */
                int curHeight = newHeights[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                maxArea = Math.max(maxArea, width * curHeight);
            }
            // 别忘了把新元素入栈
            stack.addLast(i);
        }
        return maxArea;
    }
}
