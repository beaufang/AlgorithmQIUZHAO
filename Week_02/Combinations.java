package com.beau.leetcode.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/24
 * 77 https://leetcode-cn.com/problems/combinations/
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, new LinkedList<>(), ans, n , k);
        return ans;

    }

    private void backtrack(int first, LinkedList<Integer> cur, List<List<Integer>> ans, int n, int k) {
        if (cur.size() == k) {
            ans.add(new LinkedList<>(cur));
            return;
        }
        for (int i = first; i <= n; i++) {
            cur.add(i);
            backtrack(i+1, cur, ans, n, k);
            cur.removeLast();
        }
    }

    public static void main(String[] args) {
        Combinations solution = new Combinations();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
}
