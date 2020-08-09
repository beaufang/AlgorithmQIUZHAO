package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author BeauFang
 * Date: 2020/8/7
 * 410 https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class SplitArrayLargestSum {

    /**
     * DP
     * dp[i][j] 表示把数组前 i 个数切割成 j 段，这 j 段各自求和，取和的最大值，选择各种切分方法中最大值最小的那个
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        // base case
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        // sub[i] 表示前 i 个数的和
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        for (int i = 1; i <= n; i++) {
            // 因为分割的数组每一段都不能为空，所以如果 j > i 是非法的。
            // 又因为最多只需要分割成 m 段，所以 j <= Math.min(i, m)
            for (int j = 1; j <= Math.min(i, m); j++) {
                // 把前 k 个数作为 j - 1 段, 把后 i - k 个数作为最后一段
                for (int k = 0; k < i; k++) {
                    // 取所有分割情况段和最小的情况
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 超时。。。
     * 思路：枚举所有切割点，并计算 sum。
     * 优化思路： 在计算 sum 的时候，有重复计算，可以缓存起来
     *
     * @param nums
     * @param m
     * @return
     */
    public int splitArray1(int[] nums, int m) {
        PriorityQueue<Integer> minStack = new PriorityQueue<>();
        backtrack(nums, m, 1, new LinkedList<>(), minStack);
        return minStack.peek();
    }

    private void backtrack(int[] nums, int m, int level, LinkedList<Integer> path, PriorityQueue<Integer> ans) {
        if (path.size() == m - 1) {
            ans.add(maxSum(nums, path));
            return;
        }
        // 长度为 n 的数组一共有 n - 1 个切割点
        for (int i = level; i < nums.length; i++) {
            path.addLast(i);
            backtrack(nums, m, i + 1, path, ans);
            path.removeLast();
        }
    }

    private int sum(int[] nums, int from, int to) {
        int sum = 0;
        for (int i = from; i < to; i++) {
            sum += nums[i];
        }
        return sum;
    }

    private int maxSum(int[] nums, LinkedList<Integer> splitIndex) {
        int max = Integer.MIN_VALUE;
        LinkedList<Integer> tmp = new LinkedList<>(splitIndex);
        tmp.addFirst(0);
        tmp.addLast(nums.length);
        while (tmp.size() > 1) {
            int from = tmp.poll();
            int to = tmp.peek();
            max = Math.max(sum(nums, from, to), max);
        }
        return max;
    }

    @Test
    public void test() {
        TestCase.assertEquals(18, splitArray(new int[]{7, 2, 5, 10, 8}, 2));
    }
}
