package com.beau.leetcode.week5;

import com.beau.util.ArrayUtil;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/12
 * 130 https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SurroundedRegions {

    /**
     * 并查集
     * 初始化一个虚拟节点，并将边框上的 ‘O’ 和该节点相连，然后遍历所有节点，将 ‘O’ 节点和它四周的 ‘O’ 相连，
     * 最终，所有被 ’X‘ 包围的 ’O‘ 都会和该虚拟节点相连，其他的节点都可以染色为 ’X‘
     *
     * @param board
     */
    public void solve(char[][] board) {
        int m = board.length;
        ;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;
        UnionFind uf = new UnionFind(m * n + 1);
        int dummyNode = m * n;
        // 将第一列和最后一列的 ’O‘ 和虚拟节点相连
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(getIndex(i, 0, n), dummyNode);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(getIndex(i, n - 1, n), dummyNode);
            }
        }
        // 将第一行和最后一行的 ’O‘ 和虚拟节点相连i
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                uf.union(getIndex(0, i, n), dummyNode);
            }
            if (board[m - 1][i] == 'O') {
                uf.union(getIndex(m - 1, i, n), dummyNode);
            }
        }
        // 遍历所有节点
        int[][] D = {{1, 0}, {0, 1}}; // 只需要看前面和下面
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    for (int[] d : D) {
                        int newI = i + d[0];
                        int newJ = j + d[1];
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && board[newI][newJ] == 'O') {
                            uf.union(getIndex(i, j, n), getIndex(newI, newJ, n));
                        }
                    }
                }
            }
        }
        // 填充 ’X‘
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !uf.isConnect(getIndex(i, j, n), dummyNode)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private int getIndex(int row, int col, int rowLen) {
        return row * rowLen + col;
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

        public boolean isConnect(int p, int q) {
            return find(p) == find(q);
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

    @Test
    public void test() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        ArrayUtil.print2DArray(board);
    }
}
