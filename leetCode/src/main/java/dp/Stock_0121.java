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
        for (int price : prices) {
            currentPrice = Math.min(currentPrice, price);
            maxProfits = Math.max(price - currentPrice, maxProfits);
        }
        if (maxProfits < currentPrice) {
            return 0;
        }
        return maxProfits;
    }
}
