package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/13
 * 36 https://leetcode-cn.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // 用一个 int 的  0-8 位就可以表示 1-9 之间的某个数字是否出现过
        int[] row = new int[9];
        int[] col = new int[9];
        int[][] boxes = new int[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                // 转换成 0 - 8 的 int
                int n = board[i][j] - '1';
                // 判断第 n 位是否为 1，如果是 1 ，说明该数组已经用过
                boolean rowExist = ((row[i] >> n) & 1) == 1;
                boolean colExist = ((col[j] >> n) & 1) == 1;
                boolean boxExist = ((boxes[i / 3][j / 3] >> n) & 1) == 1;
                if (rowExist || colExist || boxExist) {
                    return false;
                }
                // 将第 n 位置为 1
                row[i] |= (1 << n);
                col[j] |= (1 << n);
                boxes[i / 3][j / 3] |= (1 << n);
            }
        }
        return true;
    }
}
