package cn.qiushile.leetcode.contest;

/**
 * 6290. Maximize the Minimum Powered City
 * User Accepted:116
 * User Tried:278
 * Total Accepted:118
 * Total Submissions:532
 * Difficulty:Hard
 * You are given a 0-indexed integer array stations of length n, where stations[i] represents the number of power stations in the ith city.
 * Each power station can provide power to every city in a fixed range. In other words, if the range is denoted by r, then a power station at city i can provide power to all cities j such that |i - j| <= r and 0 <= i, j <= n - 1.
 * Note that |x| denotes absolute value. For example, |7 - 5| = 2 and |3 - 10| = 7.
 * The power of a city is the total number of power stations it is being provided power from.
 * The government has sanctioned building k more power stations, each of which can be built in any city, and have the same range as the pre-existing ones.
 * Given the two integers r and k, return the maximum possible minimum power of a city, if the additional power stations are built optimally.
 * Note that you can build the k power stations in multiple cities.
 * Example 1:
 * Input: stations = [1,2,4,5,0], r = 1, k = 2
 * Output: 5
 * Explanation:
 * One of the optimal ways is to install both the power stations at city 1.
 * So stations will become [1,4,4,5,0].
 * - City 0 is provided by 1 + 4 = 5 power stations.
 * - City 1 is provided by 1 + 4 + 4 = 9 power stations.
 * - City 2 is provided by 4 + 4 + 5 = 13 power stations.
 * - City 3 is provided by 5 + 4 = 9 power stations.
 * - City 4 is provided by 5 + 0 = 5 power stations.
 * So the minimum power of a city is 5.
 * Since it is not possible to obtain a larger power, we return 5.
 * Example 2:
 * Input: stations = [4,4,4,4], r = 0, k = 3
 * Output: 4
 * Explanation:
 * It can be proved that we cannot make the minimum power of a city greater than 4.
 * Constraints:
 * n == stations.length
 * 1 <= n <= 105
 * 0 <= stations[i] <= 105
 * 0 <= r <= n - 1
 * 0 <= k <= 109
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/7
 */
public class Solution6290 {
    public long maxPower(int[] stations, int r, int k) {
        long max = Long.MAX_VALUE;
        int n = stations.length;
        //if (r == 0) {
        //    Arrays.sort(stations);
        //    while (k > 0) {
        //        int minIndex = 0;
        //        while (minIndex < n && stations[minIndex] < stations[minIndex + 1]) {
        //
        //        }
        //    }
        //} else if (r > n - r) {
        //    int sum = 0;
        //}
        int[] power = new int[n];
        int sum = 0;
        for (int i = 0; i <= r; i++) {
            sum += stations[i];
        }
        power[0] = sum;
        for (int i = 1; i < n; i++) {
            sum += stations[i + r];
            if (i > r) {
                sum -= stations[i - r - 1];
            }
            power[i] = sum;
        }

        return 0;
    }
}
