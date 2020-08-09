package com.beau.leetcode.week4;

/**
 * @author BeauFang
 * Date: 2020/8/4
 * 221 https://leetcode-cn.com/problems/maximal-square/
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int maxEdge = 0;
        // 存储以 (i,j) 为右下角的正方形的边长
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j -1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxEdge = Math.max(maxEdge, dp[i][j]);
                }
            }
        }
        return maxEdge * maxEdge;
    }
}
