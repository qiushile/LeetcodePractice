package cn.qiushile.leetcode.medium;

import java.util.Arrays;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Medium
 * 5.6K
 * 84
 * Companies
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
 * Example 1:
 * Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 * Input: inorder = [-1], postorder = [-1]
 * Output: [-1]
 * Constraints:
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder and postorder consist of unique values.
 * Each value of postorder also appears in inorder.
 * inorder is guaranteed to be the inorder traversal of the tree.
 * postorder is guaranteed to be the postorder traversal of the tree.
 * Accepted
 * 455.3K
 * Submissions
 * 788K
 * Acceptance Rate
 * 57.8%
 * Runtime 13 ms Beats 7.25% Memory 74.8 MB Beats 5.25%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/11
 */
public class Solution0106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }
        if (inorder.length == 1) {
            if (inorder[0] == postorder[0]) {
                return new TreeNode(inorder[0]);
            } else {
                return null;
            }
        }
        int root = postorder[postorder.length - 1];
        int p = findIndex(inorder, root);
        int n = inorder.length;
        TreeNode left = p > 0? buildTree(Arrays.copyOfRange(inorder, 0, p), Arrays.copyOfRange(postorder, 0, p)): null;
        TreeNode right = (p >= 0 && p < n - 1)? buildTree(Arrays.copyOfRange(inorder, p + 1, n), Arrays.copyOfRange(postorder, p, n - 1)): null;
        return new TreeNode(root, left, right);
    }

    private int findIndex(int[] arr, int value) {
        for (int i = arr.length / 2, j = i - 1; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
            if (arr[j] == value) {
                return j;
            }
            if (j > 0) {
                j--;
            }
        }
        return -1;
    }

    public class TreeNode {
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
