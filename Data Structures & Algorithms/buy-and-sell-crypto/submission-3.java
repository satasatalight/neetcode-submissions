class Solution {
    public int maxProfit(int[] prices) {
        int mProfit = Integer.MIN_VALUE;
        int l = 0;
        int r = 1;

        for (r = 1; r < prices.length; r++) {
            int curProfit = prices[r] - prices[l];

            mProfit = Math.max(mProfit, curProfit);

            if (curProfit < 0)
                l = r;
        }
        

        return Math.max(mProfit, 0);
    }
}
