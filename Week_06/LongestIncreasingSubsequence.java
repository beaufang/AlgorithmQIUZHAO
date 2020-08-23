package com.beau.leetcode.week6;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/19
 * 300 https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {


    // O(nlogn) dp + 二分
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        // tail[i] 表示长度为 i + 1 的子序列结尾最小值
        int[] tail = new int[len];
        tail[0] = nums[0];
        // 记录 tail 数组填充的位置
        int end = 0;
        for (int i = 1; i < len; i++) {
            // 可以形成上升序列
            if (nums[i] > tail[end]) {
                tail[++end] = nums[i];
            } else {
                // 二分搜索查找 tail 数组中第一个比 num[i] 大的位置
                int left = 0, right = end, target = nums[i];
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (tail[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = target;
            }
        }
        return end + 1;
    }

    // O(n^2)
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        // dp[i] 表示以 i 结尾的最长上升子序列的长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        return ans;
    }
}
