package com.beau.leetcode.week4;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/4
 * 621 https://leetcode-cn.com/problems/task-scheduler/
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks) {
            map[c - 'A']++;
        }
        Arrays.sort(map);
        int maxCount = map[25] - 1;
        int idle = n * maxCount;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(map[i], maxCount);
        }
        return idle > 0 ? tasks.length + idle : tasks.length;
    }

}
