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
        Trie[] next = new Trie[26];
        List<Integer> ends = new ArrayList<>();
        List<Integer> mids = new ArrayList<>();
    }

    private void insert(Trie t, String w, int p) {
        for (int i = 0; i < w.length(); i++) {
            if (isPalindrome(w.substring(i))) {
                t.mids.add(p);
            }
            int c = w.charAt(i) - 'a';
            if (t.next[c] == null) {
                t.next[c] = new Trie();
            }
            t = t.next[c];
        }
        t.ends.add(p);
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
        Trie root= new Trie();
        for (int i = 0; i < n; i++) {
            insert(root, words[i], i);
        }
        for (int i = 0; i < n; i++) {
            Trie t = root;
            String w = words[i];
            int len = w.length();
            if (!t.ends.isEmpty() && isPalindrome(w)) {
                for (Integer j : t.ends) {
                    if (i != j) {
                        ans.add(List.of(j, i));
                    }
                }
            }
            int j = len - 1;
            for (; j >= 0; j--) {
                int c = w.charAt(j) - 'a';
                t = t.next[c];
                if (t == null) {
                    break;
                }
                if (!t.ends.isEmpty() && isPalindrome(w.substring(0, j))) {
                    for (Integer k : t.ends) {
                        if (k != i) {
                            ans.add(List.of(k, i));
                        }
                    }
                }
            }
            if (j < 0 && t != null && !t.mids.isEmpty()) {
                for (Integer k : t.mids) {
                    if (k != i) {
                        ans.add(List.of(k, i));
                    }
                }
            }
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
}
