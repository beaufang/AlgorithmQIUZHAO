package com.beau.leetcode.week5;

/**
 * @author BeauFang
 * Date: 2020/8/10
 * 208 https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/
 */
public class Trie {

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
