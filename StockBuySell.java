import java.util.*;

public class StockBuySell{

    //  Best Time to Buy and Sell Stock (One Transaction)
    public static int maxProfitOne(int[] prices) {
        if (prices.length == 0) return 0;
        int minPrice = prices[0], maxProfit = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else maxProfit = Math.max(maxProfit, p - minPrice);
        }
        return maxProfit;
    }

    // Best Time to Buy and Sell Stock II (Unlimited Transactions)
    public static int maxProfitMany(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }

    // Best Time to Buy and Sell Stock with Cooldown
    public static int maxProfitCooldown(int[] prices) {
        if (prices.length == 0) return 0;
        int sold = 0, hold = -prices[0], rest = 0;
        for (int i = 1; i < prices.length; i++) {
            int prevSold = sold;
            sold = hold + prices[i];
            hold = Math.max(hold, rest - prices[i]);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }

    //  Best Time to Buy and Sell Stock with Transaction Fee
    public static int maxProfitFee(int[] prices, int fee) {
        if (prices.length == 0) return 0;
        int hold = -prices[0], cash = 0;
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    //  Best Time to Buy and Sell Stock IV (At Most k Transactions)
    public static int maxProfitK(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;
        if (k >= n / 2) return maxProfitMany(prices);

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];
        Arrays.fill(buy, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int i = 1; i <= k; i++) {
                buy[i] = Math.max(buy[i], sell[i - 1] - price);
                sell[i] = Math.max(sell[i], buy[i] + price);
            }
        }
        return sell[k];
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        int fee = 1, k = 2;

        System.out.println("Stock Buy and Sell Solutions:");
        System.out.println("------------------------------------");
        System.out.println(" One Transaction: " + maxProfitOne(prices));
        System.out.println(" Unlimited Transactions: " + maxProfitMany(prices));
        System.out.println("With Cooldown: " + maxProfitCooldown(prices));
        System.out.println("With Transaction Fee (" + fee + "): " + maxProfitFee(prices, fee));
        System.out.println("At Most " + k + " Transactions: " + maxProfitK(k, prices));
    }
}