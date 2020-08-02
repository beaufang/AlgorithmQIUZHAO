package com.beau.leetcode.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/31
 * 51 https://leetcode-cn.com/problems/n-queens/
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (char[] g : grid) {
            Arrays.fill(g, '.');
        }
        List<List<String>> ans = new ArrayList<>();
        solveNQueensHelper(grid, 0, ans);
        return ans;
    }

    private void solveNQueensHelper(char[][] grid, int row, List<List<String>> ans) {
        if (row == grid.length) {
            List<String> list = new ArrayList<>();
            for (char[] l : grid) {
                list.add(new String(l));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < grid[0].length; i++) {
            // 检查是否可以放入 Queen
            if (!canPut(grid, row, i)) {
                continue;
            }
            grid[row][i] = 'Q';
            solveNQueensHelper(grid, row + 1, ans);
            grid[row][i] = '.';
        }
    }

    private boolean canPut(char[][] grid, int row, int col) {
        // 行肯定不会攻击，检查所在的列
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 'Q') {
                return false;
            }
        }
        // 检查撇
        int k = row + col;
        for (int i = 0; i < grid.length; i++) {
            if (0 <= k - i && k - i < grid.length && grid[i][k - i] == 'Q') {
                return false;
            }
        }
        // 检查捺
        int q = row - col;
        for (int i = 0; i < grid.length; i++) {
            if (0 <= i - q && i - q < grid[0].length && grid[i][i - q] == 'Q') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        List<List<String>> lists = solveNQueens(4);
        System.out.println(lists);
    }
}
