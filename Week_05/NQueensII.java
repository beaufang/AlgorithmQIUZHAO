package com.beau.leetcode.week5;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/12
 * 52 https://leetcode-cn.com/problems/n-queens-ii/
 */
public class NQueensII {

    public int totalNQueens(int n) {
        return solve(n, 0, 0, 0, 0, 0);
    }

    /**
     * @param n     棋盘大小 n * n
     * @param row   处理到第几行
     * @param col   列被占的位表示 0100,0000 表示第二列被占
     * @param pie   左对角线被占的位表示
     * @param na    右对角线被占的位表示
     * @param count 解法
     * @return 一共有多少种解法
     */
    private int solve(int n, int row, int col, int pie, int na, int count) {
        // 最后一行处理完毕
        if (row == n) {
            count++;
            return count;
        }
        // ((1 << n) - 1) 只保留低 n 位
        // pos 表示当前行可以放皇后的位表示
        int pos = ((1 << n) - 1) & (~(col | pie | na));
        while (pos != 0) {
            // 取出最低位的 1
            int p = pos & (-pos);
            // 处理下一行
            count = solve(n, row + 1, p | col, (p | pie) << 1, (p | na) >> 1, count);
            // 最低位的 1 已经用过，去掉
            pos = pos & (pos - 1);
        }
        return count;
    }

    @Test
    public void test() {
        TestCase.assertEquals(2, totalNQueens(4));
    }
}
