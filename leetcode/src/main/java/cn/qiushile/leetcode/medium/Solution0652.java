package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 652. Find Duplicate Subtrees
 * Medium
 * 3.9K
 * 332
 * Companies
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with the same node values.
 * Example 1:
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 * Example 2:
 * Input: root = [2,1,1]
 * Output: [[1]]
 * Example 3:
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 * Constraints:
 * The number of the nodes in the tree will be in the range [1, 5000]
 * -200 <= Node.val <= 200
 * Failed at 145 / 175:
 *     Wrong Answer
 *          Input
 *          root =
 *          [0,0,0,0,null,null,0,null,null,null,0]
 *          Output
 *          [[0,0],[0]]
 *          Expected
 *          [[0]]
 * Solved：Runtime 17 ms Beats 92.69% Memory 58.2 MB Beats 22.48%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/7
 */
public class Solution0652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> result = new HashSet<>();
        Map<String, TreeNode> map = new HashMap<>();

        calcTree(root, map, result);

        return new ArrayList<>(result);
    }

    private String calcTree(TreeNode node, Map<String, TreeNode> map, Set<TreeNode> result) {
        if (node == null) {
            return ".";
        }
        String curr = new StringBuilder().append("(").append(calcTree(node.left, map, result))
                .append(",").append(node.val).append(",")
                .append(calcTree(node.right, map, result)).append(")").toString();
        if (map.containsKey(curr)) {
            result.add(map.get(curr));
        } else {
            map.put(curr, node);
        }
        return curr;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
