package cn.qiushile.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 * Easy
 * 4.5K
 * 520
 * Companies
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 * Example 1:
 * Input: pattern = "abba", s = "dog cat cat dog"
 * Output: true
 * Example 2:
 * Input: pattern = "abba", s = "dog cat cat fish"
 * Output: false
 * Example 3:
 * Input: pattern = "aaaa", s = "dog cat cat dog"
 * Output: false
 * Constraints:
 * 1 <= pattern.length <= 300
 * pattern contains only lower-case English letters.
 * 1 <= s.length <= 3000
 * s contains only lowercase English letters and spaces ' '.
 * s does not contain any leading or trailing spaces.
 * All the words in s are separated by a single space.
 *
 * Runtime 2 ms Beats 38.63% Memory 40.2 MB Beats 80.47%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/1
 */
public class Solution0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        String[] ps = pattern.split("");
        if (words.length != ps.length) {
            return false;
        }
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < ps.length; i++) {
            if (map.containsKey(ps[i])) {
                if (!map.get(ps[i]).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsKey("v:" + words[i])) {
                    if (!map.get("v:" + words[i]).equals(ps[i])) {
                        return false;
                    }
                }
                map.put(ps[i], words[i]);
                map.put("v:" + words[i], ps[i]);
            }
        }
        return true;
    }
}
