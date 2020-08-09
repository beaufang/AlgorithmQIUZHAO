package com.beau.leetcode.week4;

/**
 * @author BeauFang
 * Date: 2020/8/8
 * 552 https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class StudentAttendanceRecordII {

    /**
     * 变量 AxLy 表示有 x 个 A， y 个 L。结果是否有效，可以从 A0L0 转换为其他六种状态，这六种状态继续可以进行转换。
     * 做 n 次转换，转换过程中可以有不同的选择，最后所有选择的和，就是结果
     * @param n
     * @return
     */
    public int checkRecord(int n) {
        int M = 1000000007;
        long A0L0 = 1, A0L1 = 0, A0L2 = 0;
        long A1L0 = 0, A1L1 = 0, A1L2 = 0;
        for (int i = 0; i < n; i++) {
            long newA0L0 = (A0L0 + A0L1 + A0L2) % M;
            long newA0L1 = A0L0;
            long newA0L2 = A0L1;
            long newA1L0 = (A0L0 + A0L1 + A0L2 + A1L0 + A1L1 + A1L2) % M;
            long newA1L1 = A1L0;
            long newA1L2 = A1L1;
            A0L0 = newA0L0;
            A0L1 = newA0L1;
            A0L2 = newA0L2;
            A1L0 = newA1L0;
            A1L1 = newA1L1;
            A1L2 = newA1L2;
        }
        return (int)((A0L0 + A0L1 + A0L2 + A1L0 + A1L1 + A1L2) % M);
    }
}
