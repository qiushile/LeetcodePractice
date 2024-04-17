package cn.qiushile.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 928. Minimize Malware Spread II
 * Solved
 * Hard
 * Topics
 * Companies
 * You are given a network of n nodes represented as an n x n adjacency matrix graph, where the ith node is directly connected to the jth node if graph[i][j] == 1.
 * Some nodes initial are initially infected by malware. Whenever two nodes are directly connected, and at least one of those two nodes is infected by malware, both nodes will be infected by malware. This spread of malware will continue until no more nodes can be infected in this manner.
 * Suppose M(initial) is the final number of nodes infected with malware in the entire network after the spread of malware stops.
 * We will remove exactly one node from initial, completely removing it and any connections from this node to any other node.
 * Return the node that, if removed, would minimize M(initial). If multiple nodes could be removed to minimize M(initial), return such a node with the smallest index.
 * Example 1:
 * Input: graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
 * Output: 0
 * Example 2:
 * Input: graph = [[1,1,0],[1,1,1],[0,1,1]], initial = [0,1]
 * Output: 1
 * Example 3:
 * Input: graph = [[1,1,0,0],[1,1,1,0],[0,1,1,1],[0,0,1,1]], initial = [0,1]
 * Output: 1
 * Constraints:
 * n == graph.length
 * n == graph[i].length
 * 2 <= n <= 300
 * graph[i][j] is 0 or 1.
 * graph[i][j] == graph[j][i]
 * graph[i][i] == 1
 * 1 <= initial.length < n
 * 0 <= initial[i] <= n - 1
 * All the integers in initial are unique.
 *
 * Runtime 11 ms Beats 45.85% of users with Java Memory 60.62 MB Beats 23.92% of users with Java
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/17
 */
public class Solutioin0928 {

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        Arrays.sort(initial);
        List<Integer> bad = Arrays.stream(initial).boxed().toList();
        Map<Integer, Set<Integer>> conn = new HashMap<>();
        int[] p = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(p, -1);
        for (int i = 0; i < n; i++) {
            if (p[i] == -1 && !bad.contains(i)) {
                p[i] = i;
                cnt[i] = 1;
                Set<Integer> bs = new HashSet<>();
                conn.put(i, bs);
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                while (!q.isEmpty()) {
                    Integer c = q.poll();
                    for (int j = 0; j < n; j++) {
                        if (graph[c][j] == 1 && p[j] == -1) {
                            if (bad.contains(j)) {
                                bs.add(j);
                            } else {
                                p[j] = i;
                                cnt[i]++;
                                q.offer(j);
                            }
                        }
                    }
                }
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        conn.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .forEach(e -> {
                    Integer k = e.getKey();
                    Integer v = e.getValue().iterator().next();
                    map.put(v, map.getOrDefault(v, 0) + cnt[k]);
                });
        if (map.isEmpty()) {
            return initial[0];
        } else {
            int ans = -1;
            int max = -1;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() > max || (e.getValue().equals(max) && e.getKey() < ans)) {
                    ans = e.getKey();
                    max = e.getValue();
                }
            }
            return ans;
        }
    }
}
