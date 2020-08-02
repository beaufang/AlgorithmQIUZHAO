package com.beau.leetcode.week3;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/7/27
 * 455 https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class AssignCookies {

    // 贪心，从需求最小的小朋友开始分配
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
           // 如果饼干能满足该小朋友
           if (s[j] >= g[i]) {
               i++;
           }
           j++;
        }
        return i;
    }
}
