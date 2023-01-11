package cn.qiushile.leetcode.easy;

/**
 * 112. Path Sum
 * Easy
 * 7.7K
 * 908
 * Companies
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 * Example 1:
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * Output: true
 * Explanation: The root-to-leaf path with the target sum is shown.
 * Example 2:
 * Input: root = [1,2,3], targetSum = 5
 * Output: false
 * Explanation: There two root-to-leaf paths in the tree:
 * (1 --> 2): The sum is 3.
 * (1 --> 3): The sum is 4.
 * There is no root-to-leaf path with sum = 5.
 * Example 3:
 * Input: root = [], targetSum = 0
 * Output: false
 * Explanation: Since the tree is empty, there are no root-to-leaf paths.
 * Constraints:
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * Accepted
 * 1.1M
 * Submissions
 * 2.3M
 * Acceptance Rate
 * 47.9%
 * Runtime 0 ms Beats 100% Memory 42.1 MB Beats 90.20%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/11
 */
public class Solution0112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return root != null && dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode curr, int depth, int target) {
        if (curr.left == null && curr.right == null) {
            return depth + curr.val == target;
        }
        return (curr.left != null && dfs(curr.left, depth + curr.val, target))
                || (curr.right != null && dfs(curr.right, depth + curr.val, target));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
