package cn.qiushile.leetcode.hard;

/**
 * 220. Contains Duplicate III
 * Hard
 * 592
 * 30
 * Companies
 * You are given an integer array nums and two integers indexDiff and valueDiff.
 * Find a pair of indices (i, j) such that:
 * i != j,
 * abs(i - j) <= indexDiff.
 * abs(nums[i] - nums[j]) <= valueDiff, and
 * Return true if such pair exists or false otherwise.
 * Example 1:
 * Input: nums = [1,2,3,1], indexDiff = 3, valueDiff = 0
 * Output: true
 * Explanation: We can choose (i, j) = (0, 3).
 * We satisfy the three conditions:
 * i != j --> 0 != 3
 * abs(i - j) <= indexDiff --> abs(0 - 3) <= 3
 * abs(nums[i] - nums[j]) <= valueDiff --> abs(1 - 1) <= 0
 * Example 2:
 * Input: nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3
 * Output: false
 * Explanation: After trying all the possible pairs (i, j), we cannot satisfy the three conditions, so we return false.
 * Constraints:
 * 2 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 1 <= indexDiff <= nums.length
 * 0 <= valueDiff <= 109
 * Runtime 24 ms Beats 99.48% Memory 55.7 MB Beats 19.4%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/6/2
 */
public class Solution0220 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeNode root = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (i > indexDiff) {
                root = delete(root, nums[i - indexDiff - 1]);
            }
            if (find(root, nums[i] - valueDiff, nums[i] + valueDiff)) {
                return true;
            }
            insert(root, nums[i]);
        }
        return false;
    }

    private boolean find(TreeNode root, int min, int max) {
        if (root == null) {
            return false;
        } else if (root.val >= min && root.val <= max) {
            return true;
        } else if (min < root.val) {
            return find(root.left, min, max);
        } else {
            return find(root.right, min, max);
        }
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insert(root.right, val);
            }
        }
        return root;
    }

    private TreeNode delete(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val < root.val) {
            root.left = delete(root.left, val);
        } else if (val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode max = root.left;
            while (max.right != null) {
                max = max.right;
            }
            root.val = max.val;
            root.left = delete(root.left, root.val);
        }
        return root;
    }
}
