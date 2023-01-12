package cn.qiushile.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1519. Number of Nodes in the Sub-Tree With the Same Label
 * Medium
 * 526
 * 441
 * Companies
 * You are given a tree (i.e. a connected, undirected graph that has no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges. The root of the tree is the node 0, and each node of the tree has a label which is a lower-case character given in the string labels (i.e. The node with the number i has the label labels[i]).
 * The edges array is given on the form edges[i] = [ai, bi], which means there is an edge between nodes ai and bi in the tree.
 * Return an array of size n where ans[i] is the number of nodes in the subtree of the ith node which have the same label as node i.
 * A subtree of a tree T is the tree consisting of a node in T and all of its descendant nodes.
 * Example 1:
 * Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], labels = "abaedcd"
 * Output: [2,1,1,1,1,1,1]
 * Explanation: Node 0 has label 'a' and its sub-tree has node 2 with label 'a' as well, thus the answer is 2. Notice that any node is part of its sub-tree.
 * Node 1 has a label 'b'. The sub-tree of node 1 contains nodes 1,4 and 5, as nodes 4 and 5 have different labels than node 1, the answer is just 1 (the node itself).
 * Example 2:
 * Input: n = 4, edges = [[0,1],[1,2],[0,3]], labels = "bbbb"
 * Output: [4,2,1,1]
 * Explanation: The sub-tree of node 2 contains only node 2, so the answer is 1.
 * The sub-tree of node 3 contains only node 3, so the answer is 1.
 * The sub-tree of node 1 contains nodes 1 and 2, both have label 'b', thus the answer is 2.
 * The sub-tree of node 0 contains nodes 0, 1, 2 and 3, all with label 'b', thus the answer is 4.
 * Example 3:
 * Input: n = 5, edges = [[0,1],[0,2],[1,3],[0,4]], labels = "aabab"
 * Output: [3,2,1,1,1]
 * Constraints:
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * labels.length == n
 * labels is consisting of only of lowercase English letters.
 * Accepted
 * 20.1K
 * Submissions
 * 48.4K
 * Acceptance Rate
 * 41.6%
 * BFS:
 * Runtime 271 ms Beats 38.4% Memory 127.2 MB Beats 81.52%
 * DFS:
 * Runtime 174 ms Beats 55.43% Memory 145.8 MB Beats 66.30%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/12
 */
public class Solution1519 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // bfs part
        //return bfs(n, edges, labels);

        // dfs part
        int[] ans = new int[n];
        char[] ch = labels.toCharArray();
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], s -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], s -> new HashSet<>()).add(edge[0]);
        }
        dfs(0, -1, map, ch, ans);
        return ans;
    }

    private int[] dfs(int curr, int parent, Map<Integer, Set<Integer>> map, char[] ch, int[] ans) {
        int[] counts = new int[26];
        counts[ch[curr] - 'a'] = 1;
        if (map.containsKey(curr)) {
            Set<Integer> relations = map.get(curr);
            for (Integer relation : relations) {
                if (!relation.equals(parent)) {
                    int[] childCounts = dfs(relation, curr, map, ch, ans);
                    for (int i = 0; i < 26; i++) {
                        counts[i] += childCounts[i];
                    }
                }
            }
        }
        ans[curr] = counts[ch[curr] - 'a'];
        return counts;
    }

    // bottom up: start from leaf nodes
    public int[] bfs(int n, int[][] edges, String labels) {
        char[] ch = labels.toCharArray();
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], s -> new HashSet<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], s -> new HashSet<>()).add(edge[0]);
        }

        int[][] counts = new int[n][26];
        counts[0][ch[0] - 'a'] = 1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            counts[i][ch[i] - 'a'] = 1;
            if (map.get(i).size() == 1) {
                // leaf node
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer curr = queue.poll();
            Set<Integer> relation = map.get(curr);
            Integer parent = relation.stream().findFirst().get();
            for (int i = 0; i < 26; i++) {
                counts[parent][i] += counts[curr][i];
            }
            map.get(parent).remove(curr);
            if (parent != 0 && map.get(parent).size() == 1) {
                // only one relation: parent node
                queue.offer(parent);
            }
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = counts[i][ch[i] - 'a'];
        }
        return ans;
    }
}
