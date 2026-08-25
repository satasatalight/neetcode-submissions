class Solution {
    public int trap(int[] height) {
        int area = 0;
        int bigL = height[0];

        // initialize bigRs
        int bigR = Integer.MIN_VALUE;
        int[] bigRs = new int[100001];
        Arrays.fill(bigRs, 0);

        // fill bigRs
        for (int i = 1; i < height.length; i++) {
            bigR = Math.max(bigR, height[i]);
            bigRs[height[i]]++;
        }

        for (int i = 1; i < height.length - 1; i++) {
            // get rolling largest left value
            bigL = Math.max(bigL, height[i]);

            // remove value from right value count
            bigRs[height[i]]--;

            // update bigR when all of it's entries have been passed
            while (bigR > 0 && bigRs[bigR] <= 0)
                bigR--;
            
            area += Math.max(Math.min(bigL, bigR) - height[i], 0);
        }

        return area;
    }
}
