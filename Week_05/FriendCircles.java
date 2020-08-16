package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/10
 * 547 https://leetcode-cn.com/problems/friend-circles/
 */
public class FriendCircles {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.count;
    }

    public class UnionFind {
        private int count;
        private int[] parent;

        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            parent[rootP] = rootQ;
            count--;
        }
    }
}
