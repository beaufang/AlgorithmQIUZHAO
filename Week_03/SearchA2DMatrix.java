package com.beau.leetcode.week3;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/7/30
 * 74 https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class SearchA2DMatrix {


    // 直接把整个矩阵看成一个有序数组
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / n;
            int col = mid % n;
            if (target == matrix[row][col]) {
                return true;
            }
            if (target > matrix[row][col]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length, n = matrix[0].length;
        int rowLow = 0, rowHigh = m - 1;
        // 二分查找定位所在的行
        while (rowLow <= rowHigh) {
            int rowMid = rowLow + (rowHigh - rowLow) / 2;
            if (target == matrix[rowMid][0]) {
                return true;
            }
            if (target > matrix[rowMid][0]) {
                rowLow = rowMid + 1;
            } else {
                rowHigh = rowMid - 1;
            }
        }
        rowLow--;
        if (rowLow < 0) {
            return false;
        }
        // 二分查找对应的行
        int colLow = 0, colHigh = n - 1;
        while (colLow <= colHigh) {
            int colMid = colLow + (colHigh - colLow) / 2;
            if (target == matrix[rowLow][colMid]) {
                return true;
            }
            if (target > matrix[rowLow][colMid]) {
                colLow = colMid + 1;
            } else {
                colHigh = colMid - 1;
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 11;
        TestCase.assertTrue(searchMatrix(matrix, target));
    }

    @Test
    public void test2() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
        TestCase.assertTrue(searchMatrix(matrix, target));
    }

    @Test
    public void test3() {
        int[][] matrix = {{1}};
        int target = 0;
        TestCase.assertFalse(searchMatrix(matrix, target));
    }

    @Test
    public void test4() {
        int[][] matrix = {{1}};
        int target = 1;
        TestCase.assertTrue(searchMatrix(matrix, target));
    }
}
