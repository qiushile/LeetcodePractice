package cn.qiushile.leetcode.medium;

import cn.qiushile.leetcode.entity.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 1110. Delete Nodes And Return Forest
 * Solved
 * Medium
 * Topics
 * Companies
 * Given the root of a binary tree, each node in the tree has a distinct value.
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * Return the roots of the trees in the remaining forest. You may return the result in any order.
 * Example 1:
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * Example 2:
 * Input: root = [1,2,4,null,3], to_delete = [3]
 * Output: [[1,2,4]]
 * Constraints:
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 *
 * Runtime 6 ms Beats 5.98% Memory 44.53 MB Beats 74.97%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2024/7/17
 */
public class Solution1110 {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ans = new ArrayList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Set<Integer> td = new HashSet<>(Arrays.stream(to_delete).boxed().collect(Collectors.toSet()));
        if (!td.contains(Integer.valueOf(root.val))) {
            ans.add(root);
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            if (left != null && td.contains(Integer.valueOf(left.val))) {
                node.left = null;
            }
            if (right != null && td.contains(Integer.valueOf(right.val))) {
                node.right = null;
            }
            if (td.contains(Integer.valueOf(node.val))) {
                td.remove(Integer.valueOf(node.val));
                if (left != null && !td.contains(Integer.valueOf(left.val))) {
                    ans.add(node.left);
                }
                if (right != null && !td.contains(Integer.valueOf(right.val))) {
                    ans.add(node.right);
                }
                node.left = null;
                node.right = null;
            }
            if (left != null) {
                q.offer(left);
            }
            if (right != null) {
                q.offer(right);
            }
        }
        return ans;
    }
}
