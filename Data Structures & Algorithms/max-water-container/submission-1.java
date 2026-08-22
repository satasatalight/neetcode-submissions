class Solution {
    public int maxArea(int[] heights) {
        int area = Integer.MIN_VALUE;

        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int newArea = Math.min(heights[l], heights[r]) * Math.abs(r - l);
            area = Math.max(area, newArea);

            if (heights[l] > heights[r])
                r--;
            else
                l++;
        }
        
        return area;
    }
}
