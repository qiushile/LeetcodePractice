package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. Camelcase Matching
 * Medium
 * 752
 * 272
 * Companies
 * Given an array of strings queries and a string pattern, return a boolean array answer where answer[i] is true if queries[i] matches pattern, and false otherwise.
 * A query word queries[i] matches pattern if you can insert lowercase English letters pattern so that it equals the query. You may insert each character at any position and you may not insert any characters.
 * Example 1:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * Output: [true,false,true,true,false]
 * Explanation: "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 * Example 2:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation: "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 * Example 3:
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation: "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 * Constraints:
 * 1 <= pattern.length, queries.length <= 100
 * 1 <= queries[i].length <= 100
 * queries[i] and pattern consist of English letters.
 * Runtime 0 ms Beats 100% Memory 40.4 MB Beats 82.42%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/4/14
 */
public class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String p) {
        int n = p.length();
        List<Boolean> ans = new ArrayList<>();
        for (String q : queries) {
            int m = q.length();
            int i = n - 1, j = m - 1;
            while (i >= 0) {
                char a = p.charAt(i);
                char b = q.charAt(j);
                if (a == b) {
                    i--;
                    j--;
                } else if (a >= 'A' && a <= 'Z') {
                    while (j >= 0 && (b = q.charAt(j)) >= 'a' && b <= 'z') {
                        j--;
                    }
                    if (j < 0 || a != b) {
                        ans.add(false);
                        break;
                    } else {
                        i--;
                        j--;
                    }
                } else {
                    if (b >= 'A' && b <= 'Z') {
                        ans.add(false);
                        break;
                    }
                    j--;
                    if (j < 0) {
                        ans.add(false);
                        break;
                    }
                }
            }
            if (i == -1) {
                while (j >= 0) {
                    char b = q.charAt(j);
                    if (b >= 'A' && b <= 'Z') {
                        ans.add(false);
                        j = -2;
                        break;
                    }
                    j--;
                }
                if (j == -1) {
                    ans.add(true);
                }
            }
        }
        return ans;
    }
}
