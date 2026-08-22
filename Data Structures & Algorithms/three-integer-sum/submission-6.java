class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> out = new ArrayList<>();
        Arrays.sort(nums);

        int back = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];

            if (cur == back)
                continue;
            
            if (cur > 0)
                break;
            
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int res = nums[l] + nums[r];

                if (nums[l] + nums[r] == -cur)
                    out.add(Arrays.asList(cur, nums[l], nums[r]));

                if (res > -cur) {
                    int backR = nums[r];
                    while (nums[r] == backR && r > 0)
                        r--;
                }
                
                else {
                    int backL = nums[l];
                    while (nums[l] == backL && l < r)
                        l++;
                }
            }
            
            back = cur;
        }

        return out;
    }
}
