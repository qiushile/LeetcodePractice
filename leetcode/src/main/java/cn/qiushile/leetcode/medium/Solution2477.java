package cn.qiushile.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 2477. Minimum Fuel Cost to Report to the Capital
 * Medium
 * 1.1K
 * 38
 * Companies
 * There is a tree (i.e., a connected, undirected graph with no cycles) structure country network consisting of n cities numbered from 0 to n - 1 and exactly n - 1 roads. The capital city is city 0. You are given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.
 * There is a meeting for the representatives of each city. The meeting is in the capital city.
 * There is a car in each city. You are given an integer seats that indicates the number of seats in each car.
 * A representative can use the car in their city to travel or change the car and ride with another representative. The cost of traveling between two cities is one liter of fuel.
 * Return the minimum number of liters of fuel to reach the capital city.
 * Example 1:
 * Input: roads = [[0,1],[0,2],[0,3]], seats = 5
 * Output: 3
 * Explanation:
 * - Representative1 goes directly to the capital with 1 liter of fuel.
 * - Representative2 goes directly to the capital with 1 liter of fuel.
 * - Representative3 goes directly to the capital with 1 liter of fuel.
 * It costs 3 liters of fuel at minimum.
 * It can be proven that 3 is the minimum number of liters of fuel needed.
 * Example 2:
 * Input: roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * Output: 7
 * Explanation:
 * - Representative2 goes directly to city 3 with 1 liter of fuel.
 * - Representative2 and representative3 go together to city 1 with 1 liter of fuel.
 * - Representative2 and representative3 go together to the capital with 1 liter of fuel.
 * - Representative1 goes directly to the capital with 1 liter of fuel.
 * - Representative5 goes directly to the capital with 1 liter of fuel.
 * - Representative6 goes directly to city 4 with 1 liter of fuel.
 * - Representative4 and representative6 go together to the capital with 1 liter of fuel.
 * It costs 7 liters of fuel at minimum.
 * It can be proven that 7 is the minimum number of liters of fuel needed.
 * Example 3:
 * Input: roads = [], seats = 1
 * Output: 0
 * Explanation: No representatives need to travel to the capital city.
 * Constraints:
 * 1 <= n <= 105
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads represents a valid tree.
 * 1 <= seats <= 105
 * Runtime 465 ms Beats 5.13% Memory 111.6 MB Beats 41.3%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/2/12
 */
public class Solution2477 {
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        if (n == 1) {
            return 0L;
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        Arrays.sort(roads, (a,b) -> a[0] == b[0]? a[1] - b[1] : a[0] - b[0]);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] road : roads) {
            map.computeIfAbsent(road[0], x -> new HashSet<>()).add(road[1]);
            map.computeIfAbsent(road[1], x -> new HashSet<>()).add(road[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Map<Integer, Long> members = new HashMap<>();
        Queue<Integer> leaf = new LinkedList<>();
        while (!q.isEmpty()) {
            Integer curr = q.poll();
            Set<Integer> neis = map.get(curr);
            neis.remove(curr);
            if (neis.isEmpty()) {
                leaf.add(curr);
                members.put(curr, 1L);
                continue;
            }
            for (Integer nei : neis) {
                if (parent[nei] == -1) {
                    map.get(nei).remove(curr);
                    parent[nei] = curr;
                    q.offer(nei);
                }
            }
        }
        long ans = 0L;
        while (!leaf.isEmpty()) {
            Integer curr = leaf.poll();
            if (curr == 0) {
                break;
            }
            if (!map.get(curr).isEmpty()) {
                leaf.offer(curr);
                continue;
            }
            int p = parent[curr];
            Long member = members.get(curr);
            ans += member / seats + (member % seats > 0 ? 1: 0);
            members.put(p, members.getOrDefault(p, 1L) + member);
            map.get(p).remove(curr);
            if (map.get(p).isEmpty()) {
                leaf.offer(p);
            }
        }
        return ans;
    }
}
