package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 2421. Number of Good Paths
 * Hard
 * 582
 * 21
 * Companies
 * There is a tree (i.e. a connected, undirected graph with no cycles) consisting of n nodes numbered from 0 to n - 1 and exactly n - 1 edges.
 * You are given a 0-indexed integer array vals of length n where vals[i] denotes the value of the ith node. You are also given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting nodes ai and bi.
 * A good path is a simple path that satisfies the following conditions:
 * The starting node and the ending node have the same value.
 * All nodes between the starting node and the ending node have values less than or equal to the starting node (i.e. the starting node's value should be the maximum value along the path).
 * Return the number of distinct good paths.
 * Note that a path and its reverse are counted as the same path. For example, 0 -> 1 is considered to be the same as 1 -> 0. A single node is also considered as a valid path.
 * Example 1:
 * Input: vals = [1,3,2,1,3], edges = [[0,1],[0,2],[2,3],[2,4]]
 * Output: 6
 * Explanation: There are 5 good paths consisting of a single node.
 * There is 1 additional good path: 1 -> 0 -> 2 -> 4.
 * (The reverse path 4 -> 2 -> 0 -> 1 is treated as the same as 1 -> 0 -> 2 -> 4.)
 * Note that 0 -> 2 -> 3 is not a good path because vals[2] > vals[0].
 * Example 2:
 * Input: vals = [1,1,2,2,3], edges = [[0,1],[1,2],[2,3],[2,4]]
 * Output: 7
 * Explanation: There are 5 good paths consisting of a single node.
 * There are 2 additional good paths: 0 -> 1 and 2 -> 3.
 * Example 3:
 * Input: vals = [1], edges = []
 * Output: 1
 * Explanation: The tree consists of only one node, so there is one good path.
 * Constraints:
 * n == vals.length
 * 1 <= n <= 3 * 104
 * 0 <= vals[i] <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges represents a valid tree.
 * Runtime 102 ms Beats 82.25% Memory 66.9 MB Beats 65.50%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/15
 */
public class Solution2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        int[] parent = new int[n];
        parent[0] = -1;
        int[] ancestor = new int[n];
        Arrays.fill(ancestor, -1);
        ancestor[0] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Map<Integer, Map<Integer, Integer>> all = new HashMap<>();
        HashMap<Integer, Integer> map0 = new HashMap<>();
        map0.put(0, 1);
        all.put(vals[0], map0);
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            if (!map.containsKey(curr)) {
                continue;
            }
            List<Integer> children = map.get(curr);
            for (Integer child : children) {
                if (!child.equals(parent[curr])) {
                    parent[child] = curr;
                    if (vals[child] < vals[curr]) {
                        ancestor[child] = child;
                    } else {
                        int anc = ancestor[curr];
                        while (anc > 0 && vals[parent[anc]] <= vals[child]) {
                            anc = parent[anc];
                        }
                        ancestor[child] = anc;
                    }
                    Map<Integer, Integer> childMap = all.computeIfAbsent(vals[child], c -> new HashMap<>());
                    childMap.put(ancestor[child], childMap.getOrDefault(ancestor[child], 0) + 1);
                    q.offer(child);
                }
            }
        }
        int ans = 0;
        for (Map<Integer, Integer> nodeMap : all.values()) {
            for (Integer v : nodeMap.values()) {
                ans += v * (v + 1) / 2;
            }
        }
        return ans;
    }
}
