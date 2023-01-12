package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Hard
 * 8.3K
 * 300
 * Companies
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 * Input: root = []
 * Output: []
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 * Accepted 711.6K Submissions 1.3M Acceptance Rate 55.2%
 * Runtime 13 ms Beats 79.1% Memory 43.7 MB Beats 92.93%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/11
 */
public class Solution0297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        } else if (root.left == null && root.right == null) {
            return "" + root.val;
        }
        Queue<TreeNode> curr = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        curr.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (!curr.isEmpty()) {
            TreeNode node = curr.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            sb.append(",");
            if (left != null) {
                sb.append(left.val);
                next.add(left);
            }
            sb.append(",");
            if (right != null) {
                sb.append(right.val);
                next.add(right);
            }
            if (curr.isEmpty()) {
                curr = next;
                next = new LinkedList<>();
            }
        }
        while (sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] list = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        if (list.length == 0) {
            return root;
        }
        Integer[] nums = Arrays.stream(list).map(n -> n.length() > 0? Integer.parseInt(n): null).toArray(Integer[]::new);
        List<TreeNode> last = new ArrayList<>();
        List<TreeNode> curr = new ArrayList<>();
        int n = nums.length;
        //TreeNode root = new TreeNode(nums[0]);
        last.add(root);
        int start = 1;
        int end = -1;
        int count = 1;
        int i = 0;
        while (i < n) {
            end = start + count * 2;
            count = 0;
            for (i = start; i < end && i < n; i++) {
                Integer num = nums[i];
                if (num != null) {
                    count++;
                    TreeNode node = new TreeNode(num);
                    curr.add(node);
                    TreeNode parent = last.get((i - start) / 2);
                    if ((i - start) % 2 == 0) {
                        parent.left = node;
                    } else {
                        parent.right = node;
                    }
                }
            }
            start = end;
            last = curr;
            curr = new ArrayList<>();
        }
        return root;
    }

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
