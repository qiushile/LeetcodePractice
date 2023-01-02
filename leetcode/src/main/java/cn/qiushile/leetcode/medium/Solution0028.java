package cn.qiushile.leetcode.medium;

/**
 * 28. Find the Index of the First Occurrence in a String
 * Medium
 * 1.2K
 * 89
 * Companies
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * Constraints:
 * 1 <= haystack.length, needle.length <= 104
 * haystack and needle consist of only lowercase English characters.
 *
 * Copied from https://www.zhihu.com/question/21923021/answer/1825831303
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/2
 */
public class Solution0028 {
    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        return kmp(haystack, needle);
    }

    private int kmp(String haystack, String needle) {
        char[] hArr = haystack.toCharArray();
        char[] nArr = needle.toCharArray();
        int hLen = hArr.length;
        int nLen = nArr.length;
        int[] next = next(nArr, nLen);
        int j = 0;
        for (int i = 0; i < hLen; i++) {
            // if not match, find back
            while (j > 0 && hArr[i] != nArr[j]) {
                j = next[j - 1] + 1;
                if (nLen - j + i > hLen) {
                    // too long
                    return -1;
                }
            }
            // if same, compare the next one
            if (hArr[i] == nArr[j]) {
                j++;
            }
            // it comes to the end of the needle
            if (j == nLen) {
                return i - nLen + 1;
            }
        }
        return -1;
    }

    private int[] next(char[] arr, int len) {
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < len; i++) {
            // if not match, find back
            while (k != -1 && arr[k + 1] != arr[i]) {
                k = next[k];
            }
            // if same, compare the next one
            if (arr[k + 1] == arr[i]) {
                k++;
            }
            next[i] = k;
        }
        return next;
    }
}
