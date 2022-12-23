package cn.qiushile.leetcode.medium;

/**
 * 309. Best Time to Buy and Sell Stock with Cooldown
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: prices = [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 * Example 2:
 * Input: prices = [1]
 * Output: 0
 * Constraints:
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 *
 * Runtime 41 ms Beats 5% Memory 40.4 MB Beats 89.35%
 *
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/23
 */
public class Solution0309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int startDay = 0;
        int[] earn = new int[len];
        while (startDay < len - 1 && prices[startDay] >= prices[startDay + 1]) {
            startDay++;
        }

        int currMax;
        int tmp;
        for (int currDay = startDay + 1; currDay < len; currDay++) {
            currMax = prices[currDay] - prices[startDay];
            if (currMax < 0) {
                currMax = 0;
            }
            if (startDay > 1) {
                currMax += earn[startDay -2];
            }
            for (int j = startDay + 1; j < currDay; j++) {
                tmp = prices[currDay] - prices[j + 1];
                tmp = tmp > 0? tmp + earn[j - 1]: earn[j - 1];
                if (tmp > currMax) {
                    currMax = tmp;
                }
            }
            if (currMax < earn[currDay - 1]) {
                currMax = earn[currDay - 1];
            }
            earn[currDay] = currMax;
        }
        return earn[len - 1];
    }
}
