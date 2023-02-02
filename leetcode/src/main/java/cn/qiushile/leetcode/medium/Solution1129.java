package cn.qiushile.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 1129. Shortest Path with Alternating Colors
 * Medium
 * 1.7K
 * 82
 * Companies
 * You are given an integer n, the number of nodes in a directed graph where the nodes are labeled from 0 to n - 1. Each edge is red or blue in this graph, and there could be self-edges and parallel edges.
 * You are given two arrays redEdges and blueEdges where:
 * redEdges[i] = [ai, bi] indicates that there is a directed red edge from node ai to node bi in the graph, and
 * blueEdges[j] = [uj, vj] indicates that there is a directed blue edge from node uj to node vj in the graph.
 * Return an array answer of length n, where each answer[x] is the length of the shortest path from node 0 to node x such that the edge colors alternate along the path, or -1 if such a path does not exist.
 * Example 1:
 * Input: n = 3, redEdges = [[0,1],[1,2]], blueEdges = []
 * Output: [0,1,-1]
 * Example 2:
 * Input: n = 3, redEdges = [[0,1]], blueEdges = [[2,1]]
 * Output: [0,1,-1]
 * Constraints:
 * 1 <= n <= 100
 * 0 <= redEdges.length, blueEdges.length <= 400
 * redEdges[i].length == blueEdges[j].length == 2
 * 0 <= ai, bi, uj, vj < n
 * Runtime 12 ms Beats 33.1% Memory 42.9 MB Beats 72.17%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/2
 */
public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        int[] status = new int[n]; // 1 red 2 blue 3 botha
        Map<Integer, Set<Integer>> redMap = new HashMap<>();
        Map<Integer, Set<Integer>> blueMap = new HashMap<>();
        for (int[] edge : redEdges) {
            redMap.computeIfAbsent(edge[0], x -> new HashSet<>()).add(edge[1]);
        }
        for (int[] edge : blueEdges) {
            blueMap.computeIfAbsent(edge[0], x -> new HashSet<>()).add(edge[1]);
        }
        int len = 0;
        Queue<Integer> currRed = new LinkedList<>();
        Queue<Integer> currBlue = new LinkedList<>();
        Queue<Integer> nextRed = new LinkedList<>();
        Queue<Integer> nextBlue = new LinkedList<>();
        currRed.add(0);
        currBlue.add(0);
        while (!currRed.isEmpty() || !currBlue.isEmpty()) {
            while (!currRed.isEmpty()) {
                Integer red = currRed.poll();
                if (status[red] % 2 == 0) {
                    status[red]++;
                    if (ans[red] == -1) {
                        ans[red] = len;
                    }
                    if (blueMap.containsKey(red)) {
                        nextBlue.addAll(blueMap.get(red).stream().filter(x -> status[x] < 2).toList());
                    }
                }
            }
            while (!currBlue.isEmpty()) {
                Integer blue = currBlue.poll();
                if (status[blue] < 2) {
                    status[blue] = status[blue] == 0? 2: 3;
                    if (ans[blue] == -1) {
                        ans[blue] = len;
                    }
                    if (redMap.containsKey(blue)) {
                        nextRed.addAll(redMap.get(blue).stream().filter(x -> status[x] % 2 == 0).toList());
                    }
                }
            }
            currRed = nextRed;
            currBlue = nextBlue;
            nextRed = new LinkedList<>();
            nextBlue = new LinkedList<>();
            len++;
        }
        return ans;
    }
}
