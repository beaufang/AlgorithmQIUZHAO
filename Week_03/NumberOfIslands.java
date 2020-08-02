package com.beau.leetcode.week3;

/**
 * @author BeauFang
 * Date: 2020/7/29
 * 200 https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    // 将其和所有相邻陆地设置为 0
                    maskGrid(grid, i, j);
                }
            }
        }
        return count;
    }

    private void maskGrid(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            maskGrid(grid, i, j - 1);
            maskGrid(grid, i, j + 1);
            maskGrid(grid, i - 1, j);
            maskGrid(grid, i + 1, j);
        }
    }
}
