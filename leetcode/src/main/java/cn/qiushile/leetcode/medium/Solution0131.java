package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 131. Palindrome Partitioning
 * Medium
 * 9.3K
 * 302
 * Companies
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 * Example 1:
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 * Input: s = "a"
 * Output: [["a"]]
 * Constraints:
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 * Runtime 27 ms Beats 15.61% Memory 56.2 MB Beats 44.67%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/22
 */
public class Solution0131 {
    private static Map<String, Boolean> pld = new HashMap<>();

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            ans.add(list);
            return ans;
        }
        for (int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            if (panlindrome(prefix)) {
                String suffix = s.substring(i);
                if (suffix.length() == 0) {
                    List<String> list = new ArrayList<>();
                    list.add(prefix);
                    ans.add(list);
                } else {
                    List<List<String>> lists = partition(suffix);
                    for (List<String> list : lists) {
                        list.add(0, prefix);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }

    private boolean panlindrome(String str) {
        if (pld.containsKey(str)) {
            return pld.get(str);
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                pld.put(str, false);
                return false;
            }
        }
        pld.put(str, true);
        return true;
    }
}
