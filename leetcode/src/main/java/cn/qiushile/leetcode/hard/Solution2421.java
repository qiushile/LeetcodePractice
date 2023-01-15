package cn.qiushile.leetcode.hard;

import java.util.ArrayList;
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
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/15
 */
public class Solution2421 {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        int ans = n;
        Map<Integer, List<Integer>> map = new HashMap<>(n);
        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], v -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], v -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> leafNodes = new LinkedList<>();
        int[] parent = new int[n];
        parent[0] = -1;
        // to calc parent
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            if (!map.containsKey(curr)) {
                continue;
            }
            List<Integer> children = map.get(curr);
            if (curr != 0 && children.size() == 1) {
                leafNodes.offer(curr);
            }
            Integer p = null;
            for (Integer child : children) {
                if (child.equals(parent[curr])) {
                    p = child;
                } else {
                    parent[child] = curr;
                    q.offer(child);
                }
            }
            if (p != null) {
                children.remove(p);
            }
        }

        Map<Integer, List<Map<Integer, Integer>>> counts = new HashMap<>(n);
        q = leafNodes;
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            int val = vals[curr];
            Map<Integer, Integer> currMap = new HashMap<>();
            List<Map<Integer, Integer>> mapList;
            if (counts.containsKey(curr)) {
                mapList = counts.get(curr);
                for (int i = 0; i < mapList.size(); i++) {
                    Map<Integer, Integer> map1 = mapList.get(i);
                    for (int j = i + 1; j < mapList.size(); j++) {
                        Map<Integer, Integer> map2 = mapList.get(j);
                        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                            Integer key = entry.getKey();
                            if (key >= val && map2.containsKey(key)) {
                                ans +=  entry.getValue() * map2.get(key);
                            }
                        }
                    }
                    if (map1.containsKey(val)) {
                        ans += map1.get(val);
                    }
                    for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                        Integer key = entry.getKey();
                        if (key >= val) {
                            currMap.put(key, currMap.getOrDefault(key, 0) + entry.getValue());
                        }
                    }
                }
                counts.remove(curr);
            }
            currMap.put(val, currMap.getOrDefault(val, 0) + 1);

            int p = parent[curr];
            if (p >= 0) {
                counts.computeIfAbsent(p, v -> new ArrayList<>()).add(currMap);
                map.get(p).remove(curr);
                if (map.get(p).isEmpty()) {
                    q.offer(p);
                    map.remove(p);
                }
            }
        }

        return ans;
    }
}
