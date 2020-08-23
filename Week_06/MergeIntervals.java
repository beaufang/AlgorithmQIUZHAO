package com.beau.leetcode.week6;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/17
 * 56 https://leetcode-cn.com/problems/merge-intervals/
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 1) return new int[0][0];
        // 按照区间左端点排序
        Arrays.sort(intervals, Comparator.comparingInt((a) -> a[0]));
        LinkedList<int[]> ans = new LinkedList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] last = ans.getLast();
            // 如果区间左端点大于结果集中的右区间，说明两个区间不相交，可以直接放入结果集
            if (intervals[i][0] > last[1]) {
                ans.add(intervals[i]);
            } else {
                // 执行区间合并
                last[1] = Math.max(intervals[i][1], last[1]);
            }
        }
        return ans.toArray(new int[0][0]);
    }
}
