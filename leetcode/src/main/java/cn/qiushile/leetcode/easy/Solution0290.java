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
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/1
 */
public class Solution0290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        String[] ps = pattern.split("");
        Map<String, String> map = new HashMap<>();
        boolean match = false;
        for (int i = 0; i <= words.length - ps.length; i++) {
            match = true;
            for (int j = 0; j < ps.length; j++) {
                if (map.containsKey(ps[j])) {
                    if (!map.get(ps[j]).equals(words[i + j])) {
                        match = false;
                        break;
                    }
                } else {
                    if (map.containsKey("v:" + words[i + j])) {
                        if (!map.get("v:" + words[i + j]).equals(ps[j])) {
                            match = false;
                            break;
                        }
                    }
                    map.put(ps[j], words[i + j]);
                    map.put("v:" + words[i + j], ps[j]);
                }
            }
            if (match) {
                return true;
            } else {
                map.clear();
            }
        }
        return false;
    }
}
