class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];
            Integer found = numToIndex.get(search);

            if (found != null && found != i)
                return new int[] {i, found};
        }

        return null;
    }
}
