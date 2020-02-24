package dp;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Stock_0121 {
    public static void main(String[] args) {
        int[] prices = {1,2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int maxProfits = 0;
        int currentPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            currentPrice = Math.min(currentPrice, prices[i]);
            maxProfits = Math.max(prices[i]-currentPrice,maxProfits);
        }
        if (maxProfits < currentPrice) {
            return 0;
        }
        return maxProfits;
    }
}
