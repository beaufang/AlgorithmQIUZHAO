package com.beau.leetcode.week5;


import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author BeauFang
 * Date: 2020/8/14
 * 212 https://leetcode-cn.com/problems/word-search-ii/
 */
public class WordSearchII {

    private final int[][] D = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private Trie trie;
    private char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.trie = new Trie();
        this.board = board;
        for (String word : words) {
            trie.insert(word);
        }
        Set<String> res = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, new StringBuilder(), res);
            }
        }
        return new ArrayList<>(res);
    }


    private void dfs(int i, int j, StringBuilder sb, Set<String> res) {
        char origin = board[i][j];
        // board[i][j] 已经使用
        board[i][j] = '@';
        String word = sb.append(origin).toString();
        if (!trie.startsWith(word)) {
            sb.setLength(sb.length() - 1);
            board[i][j] = origin;
            return;
        }
        if (trie.search(word)) {
            res.add(word);
        }
        for (int[] d : D) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && board[newI][newJ] != '@') {
                dfs(newI, newJ, sb, res);
            }
        }
        board[i][j] = origin;
        sb.setLength(sb.length() - 1);
    }

    static class Trie {

        private final Trie[] next;
        private boolean isEnd;

        public Trie() {
            isEnd = false;
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
            curr.isEnd = true;

        }

        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node != null;
        }

        private Trie searchPrefix(String prefix) {
            Trie node = this;
            char[] chs = prefix.toCharArray();
            for (char c : chs) {
                node = node.next[c - 'a'];
                if (node == null) {
                    return null;
                }
            }
            return node;
        }
    }

    @Test
    public void test() {
        System.out.println(findWords(new char[][]{{'a', 'a'}}, new String[]{"aa"}));
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"}));
    }
}
