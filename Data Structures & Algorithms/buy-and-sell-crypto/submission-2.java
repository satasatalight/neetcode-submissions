class Solution {
    public int maxProfit(int[] prices) {
        int mProfit = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++)
                mProfit = Math.max(mProfit, prices[j] - prices[i]);
        }

        return Math.max(mProfit, 0);
    }
}
