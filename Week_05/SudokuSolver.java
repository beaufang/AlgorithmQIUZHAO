package com.beau.leetcode.week5;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/10
 * 37 https://leetcode-cn.com/problems/sudoku-solver/
 */
public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int row, int col) {
        if (col == 9) {
            return backtrack(board, row + 1, 0);
        }
        if (row == 9) {
            return true;
        }
        if (board[row][col] != '.') {
            return backtrack(board, row, col + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, row, col, c)) {
                continue;
            }
            board[row][col] = c;
            if (backtrack(board, row, col + 1)) {
                return true;
            }
            board[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            // check row
            if (board[row][i] == c) {
                return false;
            }
            // check column
            if (board[i][col] == c) {
                return false;
            }
            // check 3 * 3 board
            if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        solveSudoku(board);

    }

}
