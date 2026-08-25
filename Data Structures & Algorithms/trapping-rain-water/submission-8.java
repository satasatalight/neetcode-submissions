class Solution {
    public int trap(int[] height) {
        int area = 0;
        int bigL = height[0];
        int bigR = Integer.MIN_VALUE;

        // find inital largest right value
        for (int i = 2; i < height.length; i++)
            bigR = Math.max(bigR, height[i]);

        for (int i = 1; i < height.length - 1; i++) {
            // get rolling largest left value
            bigL = Math.max(bigL, height[i]);

            // if currently at the largest right index, 
            // find the new largest value to the right of i
            if (height[i] == bigR) {
                bigR = Integer.MIN_VALUE;
                for (int r = i + 1; r < height.length; r++)
                    bigR = Math.max(bigR, height[r]);
            }
            
            area += Math.max(Math.min(bigL, bigR) - height[i], 0);
        }

        return area;
    }
}
