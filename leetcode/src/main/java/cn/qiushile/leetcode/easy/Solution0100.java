package cn.qiushile.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 * Easy
 * 7.9K
 * 165
 * Companies
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * Example 1:
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 * Constraints:
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 * Accepted
 * 1.3M
 * Submissions
 * 2.4M
 * Acceptance Rate
 * 56.7%
 * Runtime 0 ms Beats 100% Memory 39.9 MB Beats 70.44%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/10
 */
public class Solution0100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);
        while (!queue.isEmpty()) {
            TreeNode np = queue.poll();
            TreeNode nq = queue.poll();
            if (np != nq) {
                if (np.left == nq.left || (np.left != null && nq.left != null && np.left.val == nq.left.val)) {
                    queue.add(np.left);
                    queue.add(nq.left);
                } else {
                    return false;
                }
                if (np.right == nq.right || (np.right != null && nq.right != null && np.right.val == nq.right.val)) {
                    queue.add(np.right);
                    queue.add(nq.right);
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
