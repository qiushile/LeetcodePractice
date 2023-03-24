package cn.qiushile.leetcode.hard;

import java.util.Stack;

/**
 * 1032. Stream of Characters
 * Hard
 * 1.7K
 * 176
 * Companies
 * Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.
 * For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.
 * Implement the StreamChecker class:
 * StreamChecker(String[] words) Initializes the object with the strings array words.
 * boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.
 * Example 1:
 * Input
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * Output
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 * Explanation
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // return False
 * streamChecker.query("b"); // return False
 * streamChecker.query("c"); // return False
 * streamChecker.query("d"); // return True, because 'cd' is in the wordlist
 * streamChecker.query("e"); // return False
 * streamChecker.query("f"); // return True, because 'f' is in the wordlist
 * streamChecker.query("g"); // return False
 * streamChecker.query("h"); // return False
 * streamChecker.query("i"); // return False
 * streamChecker.query("j"); // return False
 * streamChecker.query("k"); // return False
 * streamChecker.query("l"); // return True, because 'kl' is in the wordlist
 * Constraints:
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] consists of lowercase English letters.
 * letter is a lowercase English letter.
 * At most 4 * 104 calls will be made to query.
 * Runtime 247 ms Beats 12.66% Memory 70.9 MB Beats 92.14%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/24
 */
public class Solution1032 {
    static class StreamChecker {

        private WordNode root = new WordNode();
        private Stack<Integer> stack = new Stack<>();

        public StreamChecker(String[] words) {
            for (String word : words) {
                word = word.toLowerCase();
                WordNode node = root;
                for (int i = word.length() - 1; i >= 0; i--) {
                    int p = word.charAt(i) - 'a';
                    if (node.next[p] == null) {
                        node.next[p] = new WordNode();
                    }
                    node = node.next[p];
                }
                node.isWord = true;
            }
        }

        public boolean query(char letter) {
            stack.push(letter - 'a');
            return check();
        }

        private boolean check() {
            boolean flag = false;
            WordNode node = root;
            Stack<Integer> tmp = new Stack<>();
            while (!stack.empty()) {
                int curr = stack.peek();
                if (node.next[curr] != null) {
                    node = node.next[curr];
                    if (node.isWord) {
                        flag = true;
                        break;
                    }
                    tmp.push(stack.pop());
                } else {
                    break;
                }
            }
            while (!tmp.empty()) {
                stack.push(tmp.pop());
            }
            return flag;
        }
    }

    static class WordNode {
        boolean isWord = false;
        WordNode[] next = new WordNode[26];
    }
}
