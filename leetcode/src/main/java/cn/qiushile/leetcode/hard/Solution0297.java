package cn.qiushile.leetcode.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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
 * Accepted
 * 711.6K
 * Submissions
 * 1.3M
 * Acceptance Rate
 * 55.2%
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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode left = node.left;
            TreeNode right = node.right;
            sb.append("(");
            if (left != null) {
                sb.append(left.val);
                if (left.left != null || left.right != null) {
                    queue.add(left);
                }
            }
            sb.append(",");
            if (right != null) {
                sb.append(right.val);
                if (right.left != null || right.right != null) {
                    queue.add(right);
                }
            }
            sb.append(",");
            sb.append(node.val);
            sb.append(")");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] list = data.split("\\(");
        TreeNode root = new TreeNode(Integer.parseInt(list[0]));
        if (list.length == 0) {
            return root;
        }
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(root.val, root);
        for (int i = 1; i < list.length; i++) {
            String[] nodeData = list[i].substring(0, list[i].length() - 1).split("\\,");
            TreeNode parent = map.get(Integer.parseInt(nodeData[2]));
            if (nodeData[0].length() > 0) {
                parent.left = new TreeNode(Integer.parseInt(nodeData[0]));
                map.put(parent.left.val, parent.left);
            }
            if (nodeData[1].length() > 0) {
                parent.right = new TreeNode(Integer.parseInt(nodeData[1]));
                map.put(parent.right.val, parent.right);
            }
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
