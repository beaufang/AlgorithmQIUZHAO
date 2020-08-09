package com.beau.leetcode.week4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/7
 * 363 https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 */
public class MaxSumOfRectangleNoLargerThanK {

    /**
     * 先从最简单的角度考虑，确定一个矩形需要两个点，左上角坐标和右下角坐标。枚举所有的矩形即可。
     * 如果直接用 dp 数组存取所有状态，dp 数组需要 4 个维度。
     * 实际上在进行状态转移的时候，新矩形的状态只需要左上角固定的矩形递推过来。
     * 因此，对于左上角已经适用完毕的状态可以丢弃。
     * dp[i][j] 表示右下角为 (i-1,j-1) 的矩形和。
     * 当前方格值              上方矩形和       左侧矩形和      对角线方向矩形和
     * dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1]
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int x1 = 1; x1 <= m; x1++) {
            for (int y1 = 1; y1 <= n; y1++) {
                // 每次重新创建一个
                int[][] dp = new int[m + 1][n + 1];
                for (int x2 = x1; x2 <= m; x2++) {
                    for (int y2 = y1; y2 <= n; y2++) {
                        dp[x2][y2] = matrix[x2 - 1][y2 - 1] + dp[x2 - 1][y2] + dp[x2][y2 - 1] -dp[x2 - 1][y2 - 1];
                        if (dp[x2][y2] <= k && dp[x2][y2] > max) {
                            max = dp[x2][y2];
                        }
                        if (max == k) {
                            return max;
                        }
                    }
                }
            }
        }
        return max;
    }

    @Test
    public void test1() {
        TestCase.assertEquals(10, maxSumSubmatrix(new int[][]{{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}}, 10));
    }

    @Test
    public void test2() {
        TestCase.assertEquals(-1, maxSumSubmatrix(new int[][]{{2, 2, -1}}, 0));
    }
}
