package cn.qiushile.leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * Medium
 * 5.6K
 * 127
 * Companies
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * Constraints:
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i (i.e., there will be no self-loops).
 * All the elements of graph[i] are unique.
 * The input graph is guaranteed to be a DAG.
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/30
 */
public class Solution0797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        dfs(ans, queue, graph);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, LinkedList<Integer> queue, int[][] graph) {
        int[] linked = graph[queue.getLast()];
        for (int i = 0; i < linked.length; i++) {
            if (linked[i] == graph.length - 1) {
                List<Integer> res = new ArrayList<>(queue.size() + 1);
                res.addAll(queue);
                res.add(graph.length - 1);
                ans.add(res);
                continue;
            }
            if (queue.contains(linked[i])) {
                continue;
            }
            queue.add(linked[i]);
            dfs(ans, queue, graph);
            queue.removeLast();
        }
    }
}
