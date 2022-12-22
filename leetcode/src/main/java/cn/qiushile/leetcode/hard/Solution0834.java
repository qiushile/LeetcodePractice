package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 834. Sum of Distances in Tree
 * There is an undirected connected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.
 * You are given the integer n and the array edges where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
 * Return an array answer of length n where answer[i] is the sum of the distances between the ith node in the tree and all other nodes.
 * Example 1:
 * Input: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * Output: [8,12,6,10,10,10]
 * Explanation: The tree is shown above.
 * We can see that dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * equals 1 + 1 + 2 + 2 + 2 = 8.
 * Hence, answer[0] = 8, and so on.
 * Example 2:
 * Input: n = 1, edges = []
 * Output: [0]
 * Example 3:
 * Input: n = 2, edges = [[1,0]]
 * Output: [1,1]
 * Constraints:
 * 1 <= n <= 3 * 104
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * The given input represents a valid tree.
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/22
 */
public class Solution0834 {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 0) {
            return new int[]{};
        }
        if (n == 1) {
            return new int[]{0};
        }
        if (edges.length == 0) {
            return new int[n];
        }

        int[] treeIndex = new int[n];
        Arrays.fill(treeIndex, -1);
        List<TreeNode> tree = new ArrayList<>(n);

        int rootIndex = edges[0][0];
        int firstChildIndex = edges[0][1];
        TreeNode rootNode = new TreeNode(rootIndex);
        treeIndex[rootIndex] = 0;
        TreeNode firstChildNode = new TreeNode(firstChildIndex, rootNode);
        treeIndex[firstChildIndex] = 1;
        rootNode.addChild(firstChildNode);

        tree.add(rootNode);
        tree.add(firstChildNode);

        Queue<int[]> strangeNodes = new LinkedList<>();

        for (int i = 1; i < edges.length; i++) {
            int[] edge = edges[i];
            edgeToTree(treeIndex, tree, strangeNodes, edge);
        }

        while (!strangeNodes.isEmpty()) {
            int[] edge = strangeNodes.poll();
            edgeToTree(treeIndex, tree, strangeNodes, edge);
        }

        int[] ans = new int[n];

        // calculate the number of descendants
        int descendantAmount;
        int descendantSum;
        for (int i = n - 1; i >= 0; i--) {
            TreeNode node = tree.get(i);
            if (node.isLeaf()) {
                node.descendantAmount = 0;
                node.descendantSum = 0;
            } else {
                // at least one child
                List<TreeNode> children = node.getChildren();
                int childrenAmount = children.size();
                descendantAmount = childrenAmount;
                descendantSum = childrenAmount;
                for (TreeNode child : children) {
                    descendantAmount += child.descendantAmount;
                    descendantSum += child.descendantSum + child.descendantAmount;
                }
                node.descendantAmount = descendantAmount;
                node.descendantSum = descendantSum;
                node.ancestorAmount = n - descendantAmount - 1;
            }
        }

        rootNode.ancestorAmount = 0;
        rootNode.ancestorSum = 0;
        ans[rootIndex] = rootNode.descendantSum;
        for (int i = 1; i < n; i++) {
            TreeNode node = tree.get(i);
            TreeNode parent = node.getParent();
            node.ancestorSum = parent.descendantAmount + parent.descendantSum + parent.ancestorAmount + parent.ancestorSum
                    - (node.descendantAmount + node.descendantSum + node.descendantAmount + 1);
            ans[node.label] = node.ancestorSum + node.descendantSum;
        }

        return ans;
    }

    private static void edgeToTree(int[] treeIndex, List<TreeNode> tree, Queue<int[]> strangeNodes, int[] edge) {
        int n1 = edge[0];
        int n2 = edge[1];
        if (treeIndex[n1] >= 0 && treeIndex[n2] >= 0) {
            throw new IllegalArgumentException("Illegal value, not a tree but a graph!");
        } else if (treeIndex[n1] < 0 && treeIndex[n2] < 0) {
            strangeNodes.add(edge);
        } else {
            if (treeIndex[n2] >= 0) {
                // make n1 the parent
                int tmp = n2;
                n2 = n1;
                n1 = tmp;
            }
            int parentIndex = treeIndex[n1];
            TreeNode parent = tree.get(parentIndex);
            TreeNode child = new TreeNode(n2, parent);
            parent.addChild(child);
            treeIndex[n2] = tree.size();
            tree.add(child);
        }
    }


    /**
     * Definition for a tree node.
     */
    public static class TreeNode {
        int label;
        private TreeNode parent;
        private List<TreeNode> children;
        private boolean isLeaf;
        int descendantAmount = -1;
        int ancestorAmount = -1;
        int descendantSum = -1;
        int ancestorSum = -1;
        TreeNode() {
            this.isLeaf = true;
        }
        public TreeNode(int label) {
            this();
            this.label = label;
        }
        public TreeNode(int label, TreeNode parent) {
            this(label);
            this.parent = parent;
        }
        public TreeNode(int label, TreeNode parent, TreeNode child) {
            this(label, parent);
            this.children = new ArrayList<>();
            this.children.add(child);
            this.isLeaf = false;
        }
        public TreeNode(int label, TreeNode parent, TreeNode[] children) {
            this(label, parent);
            this.children = List.of(children);
            this.isLeaf = false;
        }

        public TreeNode addChild(TreeNode child) {
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(child);
            this.isLeaf = false;
            return this;
        }

        public List<TreeNode> getChildren() {
            return children;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public boolean isLeaf() {
            return isLeaf;
        }
    }
}
