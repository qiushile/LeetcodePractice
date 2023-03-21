package cn.qiushile.leetcode.medium;

/**
 * 1616. Split Two Strings to Make Palindrome
 * Medium
 * 634
 * 225
 * Companies
 * You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.
 * When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
 * Return true if it is possible to form a palindrome string, otherwise return false.
 * Notice that x + y denotes the concatenation of strings x and y.
 * Example 1:
 * Input: a = "x", b = "y"
 * Output: true
 * Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
 * Example 2:
 * Input: a = "xbdef", b = "xecab"
 * Output: false
 * Example 3:
 * Input: a = "ulacfd", b = "jizalu"
 * Output: true
 * Explaination: Split them at index 3:
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 * Constraints:
 * 1 <= a.length, b.length <= 105
 * a.length == b.length
 * a and b consist of lowercase English letters
 * Runtime 10 ms Beats 13.85% Memory 43.2 MB Beats 45.13%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/21
 */
public class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        if (a == null || a.length() <= 1) {
            return true;
        }
        int n = a.length();
        boolean paa = true;
        boolean pbb = true;
        boolean pab = true;
        boolean pba = true;
        int pa = n;
        int pb = n;
        for (int i = n / 2; i >= 0; i--) {
            if (paa && a.charAt(i) != a.charAt(n - i - 1)) {
                paa = false;
                pa = i + 1;
            }
            if (pbb && b.charAt(i) != b.charAt(n - i - 1)) {
                pbb = false;
                pb = i + 1;
            }
            if (!paa && !pbb) {
                break;
            }
        }
        if (paa || pbb) {
            return true;
        }
        for (int i = 0; i <= n / 2; i++) {
            if (pab) {
                if (a.charAt(i) == b.charAt(n - i - 1)) {
                    if (pa <= i + 1 || pb <= i + 1 || i == n / 2 - 1) {
                        return true;
                    }
                } else {
                    pab = false;
                }
            }
            if (pba) {
                if (b.charAt(i) == a.charAt(n - i - 1)) {
                    if (pa <= i + 1 || pb <= i + 1 || i == n / 2 - 1) {
                        return true;
                    }
                } else {
                    pba = false;
                }
            }
            if (!pab && !pba) {
                break;
            }
        }
        return false;
    }
}
