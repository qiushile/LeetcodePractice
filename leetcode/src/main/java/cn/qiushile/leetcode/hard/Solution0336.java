package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 336. Palindrome Pairs
 * Hard
 * 4.2K
 * 432
 * Companies
 * You are given a 0-indexed array of unique strings words.
 * A palindrome pair is a pair of integers (i, j) such that:
 * 0 <= i, j < words.length,
 * i != j, and
 * words[i] + words[j] (the concatenation of the two strings) is a
 * palindrome
 * Return an array of all the palindrome pairs of words.
 * Example 1:
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation: The palindromes are ["abcddcba","dcbaabcd","slls","llssssll"]
 * Example 2:
 * Input: words = ["bat","tab","cat"]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["battab","tabbat"]
 * Example 3:
 * Input: words = ["a",""]
 * Output: [[0,1],[1,0]]
 * Explanation: The palindromes are ["a","a"]
 * Constraints:
 * 1 <= words.length <= 5000
 * 0 <= words[i].length <= 300
 * words[i] consists of lowercase English letters.
 * Failed at Memory Limit Exceeded - 135 / 136 test cases passed.
 * @author qiushile <qiushile@sina.com>
 * @date 2023/5/4
 */
public class Solution0336 {
    class Trie {
        int p = -1;
        Trie[] next = new Trie[26];
    }

    private void insert(Trie t, String w, int p) {
        for (int i = 0; i < w.length(); i++) {
            int c = w.charAt(i) - 'a';
            if (t.next[c] == null) {
                t.next[c] = new Trie();
            }
            t = t.next[c];
        }
        t.p = p;
    }

    private int find(Trie t, String w) {
        for (int i = 0; i < w.length(); i++) {
            int c = w.charAt(i) - 'a';
            if (t.next[c] == null) {
                return -1;
            }
            t = t.next[c];
        }
        return t.p;
    }

    private String reverse(String w) {
        StringBuilder sb = new StringBuilder(w);
        sb.reverse();
        return sb.toString();
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        if (n < 2) {
            return ans;
        }
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        qsort(words, indices, 0, n - 1);
        Trie root1 = new Trie();
        Trie root2 = new Trie();
        insert(root1, words[0], 0);
        insert(root2, reverse(words[0]), 0);
        for (int i = 1; i < n; i++) {
            Trie t1 = root1;
            Trie t2 = root2;
            String w = words[i];
            int len = w.length();
            if (t1.p == 0 && isPalindrome(w)) {
                ans.add(List.of(indices[i], indices[t1.p]));
                ans.add(List.of(indices[t1.p], indices[i]));
            }
            for (int j = 0; j < len; j++) {
                int c = w.charAt(j) - 'a';
                if (t2 != null) {
                    t2 = t2.next[c];
                    if (t2 != null && t2.p >= 0 && t2.p != i) {
                        if (isPalindrome(w.substring(j + 1))) {
                            ans.add(List.of(indices[i], indices[t2.p]));
                        }
                    }
                }
                c = w.charAt(len - 1 - j) - 'a';
                if (t1 != null) {
                    t1 = t1.next[c];
                    if (t1 != null && t1.p >= 0 && t1.p != i) {
                        if (isPalindrome(w.substring(0, len - 1 - j))) {
                            ans.add(List.of(indices[t1.p], indices[i]));
                        }
                    }
                }
                if (t1 == null && t2 == null) {
                    break;
                }
            }
            insert(root1, w, i);
            insert(root2, reverse(w), i);
        }
        return ans;
    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    private void qsort(String[] words, int[] indices, int left, int right) {
        int n = indices.length;
        if (left >= 0 && left < right && right < n) {
            String k = words[left];
            int v = indices[left];
            int l = left;
            int r = right;
            while (l < r) {
                while (l < r && words[r].length() >= k.length()) {
                    r--;
                }
                if (l < r && words[r].length() < k.length()) {
                    words[l] = words[r];
                    indices[l] = indices[r];
                    l++;
                }
                while (l < r && words[l].length() <= k.length()) {
                    l++;
                }
                if (l < r && words[l].length() > k.length()) {
                    words[r] = words[l];
                    indices[r] = indices[l];
                    r--;
                }
            }
            words[l] = k;
            indices[l] = v;
            qsort(words, indices, left, l - 1);
            qsort(words, indices, l + 1, right);
        }
    }
}
