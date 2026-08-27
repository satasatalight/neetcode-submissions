class Solution {
    public int maxProfit(int[] prices) {
        int mProfit = Integer.MIN_VALUE;
        
        for (int i = 0; i < prices.length; i++) {
            int buyAt = prices[i];

            for (int j = i + 1; j < prices.length; j++)
                mProfit = Math.max(mProfit, prices[j] - buyAt);
        }

        return Math.max(mProfit, 0);
    }
}
