package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 1096. Brace Expansion II
 * Hard
 * 435
 * 264
 * Companies
 * Under the grammar given below, strings can represent a set of lowercase words. Let R(expr) denote the set of words the expression represents.
 * The grammar can best be understood through simple examples:
 * Single letters represent a singleton set containing that word.
 * R("a") = {"a"}
 * R("w") = {"w"}
 * When we take a comma-delimited list of two or more expressions, we take the union of possibilities.
 * R("{a,b,c}") = {"a","b","c"}
 * R("{{a,b},{b,c}}") = {"a","b","c"} (notice the final set only contains each word at most once)
 * When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
 * R("{a,b}{c,d}") = {"ac","ad","bc","bd"}
 * R("a{b,c}{d,e}f{g,h}") = {"abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"}
 * Formally, the three rules for our grammar:
 * For every lowercase letter x, we have R(x) = {x}.
 * For expressions e1, e2, ... , ek with k >= 2, we have R({e1, e2, ...}) = R(e1) ∪ R(e2) ∪ ...
 * For expressions e1 and e2, we have R(e1 + e2) = {a + b for (a, b) in R(e1) × R(e2)}, where + denotes concatenation, and × denotes the cartesian product.
 * Given an expression representing a set of words under the given grammar, return the sorted list of words that the expression represents.
 * Example 1:
 * Input: expression = "{a,b}{c,{d,e}}"
 * Output: ["ac","ad","ae","bc","bd","be"]
 * Example 2:
 * Input: expression = "{{a,z},a{b,c},{ab,z}}"
 * Output: ["a","ab","ac","z"]
 * Explanation: Each distinct word is written only once in the final answer.
 * Constraints:
 * 1 <= expression.length <= 60
 * expression[i] consists of '{', '}', ','or lowercase English letters.
 * The given expression represents a set of words based on the grammar given in the description.
 * Runtime 20 ms Beats 67.14% Memory 44.5 MB Beats 24.29%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/3/7
 */
public class Solution1096 {
    public List<String> braceExpansionII(String expression) {
        Stack<String> stack = new Stack<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            String last = stack.empty()? "=": stack.peek();
            if (c == '}') {
                list = new ArrayList<>();
                String str;
                StringBuilder sb = new StringBuilder();
                while (!((str = stack.pop()).equals("{"))) {
                    if (str.equals(",")) {
                        Collections.addAll(list, sb.toString().split(","));
                        sb = new StringBuilder();
                    } else {
                        sb.insert(0, str);
                    }
                }
                Collections.addAll(list, sb.toString().split(","));
                Collections.reverse(list);
                str = null;
                if (!stack.empty() && !stack.peek().equals("{") && !stack.peek().equals(",")) {
                    str = stack.pop();
                }
                if (str != null) {
                    String[] strs = str.split(",");
                    List<String> tmp = new ArrayList<>();
                    for (int j = 0; j < list.size(); j++) {
                        for (String s : strs) {
                            tmp.add(s + list.get(j));
                        }
                    }
                    list = tmp;
                }
                stack.push(list.stream().collect(Collectors.joining(",")));
            } else if (c >= 'a' && c <= 'z' && last.charAt(0) >= 'a' && last.charAt(0) <= 'z') {
                stack.pop();
                String[] strs = last.split(",");
                list = new ArrayList<>();
                for (String str : strs) {
                    list.add(str + c);
                }
                stack.push(list.stream().collect(Collectors.joining(",")));
            } else {
                stack.push(String.valueOf(c));
            }
        }
        Set<String> set = new HashSet<>(Arrays.asList(stack.pop().split(",")));
        while (!stack.empty()) {
            Set<String> tmp = new HashSet<>();
            String[] strs = stack.pop().split(",");
            for (String s1 : set) {
                for (String s0 : strs) {
                    tmp.add(s0 + s1);
                }
            }
            set = tmp;
        }
        list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

}
