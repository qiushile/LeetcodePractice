package cn.qiushile.leetcode.medium;

import java.util.Stack;

/**
 * 394. Decode String
 * Medium
 * 10.1K
 * 445
 * Companies
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 105.
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 * Accepted 603.4K Submissions 1M Acceptance Rate 57.8%
 * Runtime 1 ms Beats 90.34% Memory 40.2 MB Beats 91.32%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/10
 */
public class Solution0394 {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        String lastLetter = "";
        String lastNumber = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (lastLetter.length() > 0) {
                    stack.push(lastLetter);
                    lastLetter = "";
                }
                lastNumber = lastNumber + Character.toString(c);
            } else if (c >= 'a' && c <= 'z') {
                if (lastNumber.length() > 0) {
                    stack.push(lastNumber);
                    lastNumber = "";
                }
                lastLetter = lastLetter + Character.toString(c);
            } else if (c == '[') {
                if (lastLetter.length() > 0) {
                    stack.push(lastLetter);
                    lastLetter = "";
                }
                if (lastNumber.length() > 0) {
                    stack.push(lastNumber);
                    lastNumber = "";
                }
            } else {  // ]
                String str = stack.pop();
                while (!Character.isDigit(str.charAt(0))) {
                    lastLetter = str + lastLetter;
                    str = stack.pop();
                }
                int num = Integer.parseInt(str);
                if (lastLetter.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    while (num > 0) {
                        sb.append(lastLetter);
                        num--;
                    }
                    lastLetter = "";
                    if (stack.empty()) {
                        stack.push(sb.toString());
                    } else {
                        while (!stack.empty() &&
                                ((str = stack.peek()) != null) &&
                                !Character.isDigit(str.charAt(0))) {
                            stack.pop();
                            sb.insert(0, str);
                        }
                        stack.push(sb.toString());
                    }
                }
            }
            i++;
        }
        return (stack.empty()? "": stack.peek()) + lastLetter;
    }
}
