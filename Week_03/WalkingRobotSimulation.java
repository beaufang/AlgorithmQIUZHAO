package com.beau.leetcode.week3;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BeauFang
 * Date: 2020/7/28
 * 874 https://leetcode-cn.com/problems/walking-robot-simulation/
 */
public class WalkingRobotSimulation {

    public int robotSim(int[] commands, int[][] obstacles) {
        // 当前的朝向，0-3 分别代表 北东南西
        int direction = 0;
        // 定义方向数组：北东南西
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 当前坐标
        int x = 0, y = 0;
        // 距离结果
        int ans = 0;
        // 将障碍物坐标点放入 set，方便查询
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }
        // 执行行走模拟
        for (int command : commands) {
            // 如果是前进命令
            if (command > 0) {
                // 一格一格的走
                for (int i = 0; i < command; i++) {
                    int nextX = x + directions[direction][0];
                    int nextY = y + directions[direction][1];
                    // 被障碍物拦截
                    if (set.contains(nextX + "," + nextY)) {
                        break;
                    }
                    // 更新坐标和距离
                    x = nextX;
                    y = nextY;
                    ans = Math.max(ans, x * x + y * y);
                }
            } else {
                // 更新方向
                direction = command == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }
}
