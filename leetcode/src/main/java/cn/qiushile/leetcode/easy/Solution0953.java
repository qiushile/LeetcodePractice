package cn.qiushile.leetcode.easy;

/**
 * 953. Verifying an Alien Dictionary
 * Easy
 * 4K
 * 1.3K
 * Companies
 * In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographically in this alien language.
 * Example 1:
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
 * Constraints:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 * Runtime 0 ms Beats 100% Memory 40.6 MB Beats 92.34%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/2
 */
public class Solution0953 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        for (int i = 0; i < 26; i++) {
            orders[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].length() > words[i].length() && words[i - 1].startsWith(words[i])) {
                return false;
            } else {
                int len = Math.min(words[i - 1].length(), words[i].length());
                for (int j = 0; j < len; j++) {
                    int prev = orders[words[i - 1].charAt(j) - 'a'];
                    int curr = orders[words[i].charAt(j) - 'a'];
                    if (prev > curr) {
                        return false;
                    } else if (prev < curr) {
                        break;
                    }
                }
            }
        }
        return true;
    }
}
