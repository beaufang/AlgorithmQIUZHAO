package com.beau.leetcode.week5;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/15
 * 212 https://leetcode-cn.com/problems/word-search-ii/
 * 该解法直接在遍历的过程中修改 Trie
 */
public class WordSearchII_2 {

    private final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        this.board = board;
        for (String word : words) {
            trie.insert(word);
        }
        List<String> res = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, res, trie);
            }
        }
        return res;
    }


    private void dfs(int i, int j,  List<String> res, Trie trie) {
        char origin = board[i][j];
        trie = trie.next[origin - 'a'];
        if (trie == null) return;
        if (trie.word != null) {
            res.add(trie.word);
            // 将该节点的单词置空，防止结果重复
            trie.word = null;
        }
        board[i][j] = '@';
        for (int[] d : D) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && board[newI][newJ] != '@') {
                dfs(newI, newJ, res, trie);
            }
        }
        board[i][j] = origin;
    }

    static class Trie {

        private final Trie[] next;
        private String word;

        public Trie() {
            next = new Trie[26];
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            Trie curr = this;
            char[] chs = word.toCharArray();
            for (char c : chs) {
                int n = c - 'a';
                if (curr.next[n] == null) {
                    curr.next[n] = new Trie();
                }
                curr = curr.next[n];
            }
            curr.word = word;

        }
    }

    @Test
    public void test() {
        System.out.println(findWords(new char[][]{{'a', 'a'}}, new String[]{"aa"}));
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"}));

        System.out.println(findWords(new char[][]{{'a','a'}},
                new String[]{"aaa"}));
    }
}
