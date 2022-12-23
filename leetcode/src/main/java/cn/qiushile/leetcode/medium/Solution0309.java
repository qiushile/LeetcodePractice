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
 * @author qiushile <qiushile@sina.com>
 * @date 2022/12/23
 */
public class Solution0309 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int index = 0;
        int startPrice;
        int earn = 0;
        while (index <= len - 1) {
            while (index < len - 1 && prices[index] >= prices[index + 1]) {
                index++;
            }
            startPrice = prices[index];
            index++;
            while (index < len - 1 && (prices[index] <= prices[index + 1] || (index < len - 2 && prices[index + 2] > prices[index + 1]))) {
                if (prices[index + 1] >= prices[index]) {
                    index++;
                    continue;
                }
                if (index < len - 2 && prices[index] > prices[index + 1] && prices[index + 2] > prices[index + 1]) {
                    if (prices[index + 2] - startPrice > prices[index + 2] - prices[index + 1] + prices[index - 1] - startPrice
                            && prices[index + 2] - startPrice > prices[index] - startPrice) {
                        index = index + 2;
                    } else if (prices[index + 2] - prices[index + 1] + prices[index - 1] - startPrice > prices[index] - startPrice) {
                        earn += prices[index - 1] - startPrice;
                        startPrice = prices[index];
                        break;
                    } else {
                        earn += prices[index] - startPrice;
                        index = index + 2;
                        startPrice = prices[index];
                        break;
                    }
                }
            }

            if (index <= len - 1 && prices[index] > startPrice) {
                earn += prices[index] - startPrice;
                continue;
            }
        }
        return earn;
    }
}
