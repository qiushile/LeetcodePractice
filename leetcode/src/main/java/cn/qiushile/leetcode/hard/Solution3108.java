package cn.qiushile.leetcode.hard;

import java.util.Arrays;

/**
 * 3108. Minimum Cost Walk in Weighted Graph
 * 100244 in contest
 * Solved
 * Hard
 * Topics
 * Companies
 * Hint
 * There is an undirected weighted graph with n vertices labeled from 0 to n - 1.
 * You are given the integer n and an array edges, where edges[i] = [ui, vi, wi] indicates that there is an edge between vertices ui and vi with a weight of wi.
 * A walk on a graph is a sequence of vertices and edges. The walk starts and ends with a vertex, and each edge connects the vertex that comes before it and the vertex that comes after it. It's important to note that a walk may visit the same edge or vertex more than once.
 * The cost of a walk starting at node u and ending at node v is defined as the bitwise AND of the weights of the edges traversed during the walk. In other words, if the sequence of edge weights encountered during the walk is w0, w1, w2, ..., wk, then the cost is calculated as w0 & w1 & w2 & ... & wk, where & denotes the bitwise AND operator.
 * You are also given a 2D array query, where query[i] = [si, ti]. For each query, you need to find the minimum cost of the walk starting at vertex si and ending at vertex ti. If there exists no such walk, the answer is -1.
 * Return the array answer, where answer[i] denotes the minimum cost of a walk for query i.
 * Example 1:
 * Input: n = 5, edges = [[0,1,7],[1,3,7],[1,2,1]], query = [[0,3],[3,4]]
 * Output: [1,-1]
 * Explanation:
 * To achieve the cost of 1 in the first query, we need to move on the following edges: 0->1 (weight 7), 1->2 (weight 1), 2->1 (weight 1), 1->3 (weight 7).
 * In the second query, there is no walk between nodes 3 and 4, so the answer is -1.
 * Example 2:
 * Input: n = 3, edges = [[0,2,7],[0,1,15],[1,2,6],[1,2,1]], query = [[1,2]]
 * Output: [0]
 * Explanation:
 * To achieve the cost of 0 in the first query, we need to move on the following edges: 1->2 (weight 1), 2->1 (weight 6), 1->2 (weight 1).
 * Constraints:
 * 2 <= n <= 105
 * 0 <= edges.length <= 105
 * edges[i].length == 3
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= wi <= 105
 * 1 <= query.length <= 105
 * query[i].length == 2
 * 0 <= si, ti <= n - 1
 * si != ti
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2024/4/7
 */
public class Solution3108 {

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] p = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
            v[i] = -1;
        }
        Arrays.sort(edges, (a, b) -> Math.min(a[0], a[1]) - Math.min(b[0], b[1]));
        for (int[] e : edges) {
            merge(p, v, e[0], e[1], e[2]);
        }

        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];
            ans[i] = q[0] == q[1]? 0: (find(p, q[0]) == find(p, q[1])? v[p[q[0]]]: -1);
        }
        return ans;
    }

    private int find(int[] p, int a) {
        while (p[p[a]] != p[a]) {
            p[a] = find(p, p[a]);
        }
        return p[a];
    }

    private int merge(int[] p, int[] v, int a, int b, int c) {
        int xa = a;
        while (p[xa] != xa) {
            xa = p[xa];
        }
        int xb = b;
        while (p[xb] != xb) {
            xb = p[xb];
        }
        int x = Math.min(xa, xb);
        if (v[xa] >= 0) {
            c &= v[xa];
        }
        if (v[xb] >= 0) {
            c &= v[xb];
        }
        v[x] = c;

        while (p[a] != x) {
            xa = p[a];
            p[a] = x;
            a = xa;
        }
        while (p[b] != x) {
            xb = p[b];
            p[b] = x;
            b = xb;
        }
        return x;
    }
}
