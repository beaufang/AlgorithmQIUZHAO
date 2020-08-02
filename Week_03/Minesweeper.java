package com.beau.leetcode.week3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/7/30
 * 529 https://leetcode-cn.com/problems/minesweeper/
 */
public class Minesweeper {

    public char[][] updateBoard(char[][] board, int[] click) {
        // 周围的 8 个方向
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        int row = click[0], col = click[1];
        // 如果点击的是地雷，则爆炸
        if (board[row][col] == 'M' || board[row][col] == 'X') {
            board[row][col] = 'X';
            return board;
        }

        int m = board.length, n = board[0].length;
        // 地雷的数量
        int num = 0;
        for (int[] d : dirs) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n && board[newRow][newCol] == 'M') {
                num++;
            }
        }
        // 如果周边有雷
        if (num > 0) {
            board[row][col] = (char) (num + '0');
            return board;
        }
        board[row][col] = 'B';
        // 如果周边无雷
        for (int[] d : dirs) {
            int newRow = row + d[0];
            int newCol = col + d[1];
            if (0 <= newRow && newRow < m && 0 <= newCol && newCol < n && board[newRow][newCol] == 'E') {
                updateBoard(board, new int[]{newRow, newCol});
            }
        }

        return board;
    }

    @Test
    public void test() {
        char[][] board = {
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        updateBoard(board, click);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }

    }
}
