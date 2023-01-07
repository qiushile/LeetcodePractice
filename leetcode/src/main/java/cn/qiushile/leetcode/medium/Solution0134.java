package cn.qiushile.leetcode.medium;

/**
 * 134. Gas Station
 * Medium
 * 7.6K
 * 702
 * Companies
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique
 * Example 1:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 * Constraints:
 * n == gas.length == cost.length
 * 1 <= n <= 105
 * 0 <= gas[i], cost[i] <= 104
 * Failed:
 * Memory Limit Exceeded at 32/37
 * Time Limit Exceeded at 34/37
 * @author qiushile <qiushile@sina.com>
 * @date 2023/1/7
 */
public class Solution0134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        int[] remain = new int[n];
        int[] available = new int[n];
        int[] tillPoint = new int[n];
        int[] tillSum = new int[n];
        for (int i = 0; i < n; i++) {
            remain[i] = gas[i] - cost[i];
            sum += remain[i];
        }
        if (sum < 0) {
            return -1;
        }
        if (n == 1) {
            return remain[0] < 0? -1 : 0;
        }
        for (int i = 0; i < n; i++) {
            if (remain[i] < 0) {
                available[i] = -1;
                tillPoint[i] = -1;
            } else {
                tillPoint[i] = (i + 1) % n;
                tillSum[i] = remain[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (available[i] == -1) {
                continue;
            }
            int j = (i + 1) % n;
            // calculate from i + 1 to i - 1
            while (j != i) {
                if (available[j] == -1) {
                    int currSum = tillSum[i] + remain[j];
                    if (currSum < 0) {
                        available[i] = -1;
                        break;
                    } else {
                        tillPoint[i] = j;
                        tillSum[i] = currSum;
                        if (j == (i - 1 + n)% n) {
                            return i;
                        }
                    }
                    j = (j + 1) % n;
                } else {
                    int nextj = tillPoint[j];
                    if (i < j) {
                        if (nextj >= (i - 1 + n)% n && nextj < j) {
                            return i;
                        }
                    } else {
                        if (nextj >= i - 1) {
                            return i;
                        }
                    }
                    tillSum[i] += tillSum[j];
                    tillPoint[i] = nextj;
                    j = nextj;
                }
            }
        }
        return -1;
    }
}
