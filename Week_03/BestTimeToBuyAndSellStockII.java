package com.beau.leetcode.week3;

/**
 * @author BeauFang
 * Date: 2020/7/27
 * 122 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class BestTimeToBuyAndSellStockII {

    // 贪心
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int ans = 0;
        int pre = prices[0];
        for (int p : prices) {
            int profit = p - pre;
            // 只要有利可图，就拿
            if (profit > 0) {
                ans += profit;
            }
            pre = p;
        }
        return ans;
    }

    // 动态规划
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // dp[i][0] 表示当天不持有股票的总利润
        // dp[i][1] 表示当天持有股票的总利润
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 前一天不持有股票 or 前一天持有股票，今天卖出
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    // 动态规划，状态压缩
    public int maxProfit3(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        // 因为递推的过程，只关注前一次的状态，所以只需要保存前一次状态即可
        // 前一次持有现金
        int cash = 0;
        // 前一次持有股票
        int stock = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // 前一天不持有股票 or 前一天持有股票，今天卖出
           cash = Math.max(cash, stock + prices[i]);
           stock = Math.max(stock, cash - prices[i]);
        }
        return cash;
    }


}
