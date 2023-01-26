package cn.qiushile.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 787. Cheapest Flights Within K Stops
 * Medium
 * 6.5K
 * 294
 * Companies
 * There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
 * You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
 * Example 1:
 * Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1
 * Output: 700
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
 * Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
 * Example 2:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1
 * Output: 200
 * Explanation:
 * The graph is shown above.
 * The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
 * Example 3:
 * Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 0
 * Output: 500
 * Explanation:
 * The graph is shown above.
 * The optimal path with no stops from city 0 to 2 is marked in red and has cost 500.
 * Constraints:
 * 1 <= n <= 100
 * 0 <= flights.length <= (n * (n - 1) / 2)
 * flights[i].length == 3
 * 0 <= fromi, toi < n
 * fromi != toi
 * 1 <= pricei <= 104
 * There will not be any multiple flights between two cities.
 * 0 <= src, dst, k < n
 * src != dst
 * Runtime 54 ms Beats 5.6% Memory 48.4 MB Beats 6.99%
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/26
 */
public class Solution0787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<int[]>> prices = new HashMap<>(n);
        for (int[] flight: flights) {
            prices.computeIfAbsent(flight[0], x -> new HashSet<>()).add(new int[]{flight[1], flight[2]});
        }
        Map<Integer, Integer> curr = new HashMap<>(n);
        Map<Integer, Integer> next = new HashMap<>(n);
        Set<Integer> changed = new HashSet<>();
        curr.put(src, 0);
        next.put(src, 0);
        for (int i = 0; i <= k; i++) {
            for (int[] flight : flights) {
                if (curr.containsKey(flight[0])) {
                    int newPrice = curr.get(flight[0]) + flight[2];
                    if (!next.containsKey(flight[1]) || newPrice < next.get(flight[1])) {
                        next.put(flight[1], newPrice);
                        changed.add(flight[1]);
                    }
                }
            }
            for (Integer city : changed) {
                curr.put(city, next.get(city));
            }
            changed.clear();
        }
        return curr.getOrDefault(dst, -1);
    }
}