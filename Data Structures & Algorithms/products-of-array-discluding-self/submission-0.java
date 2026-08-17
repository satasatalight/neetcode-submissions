class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int fullProduct = 1;

        for (int num : nums)
            if (num != 0)
                fullProduct *= num;
            else
                zeroCount++;

        int[] out = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
            if (zeroCount == 0)
                out[i] = fullProduct / nums[i];
            else if (zeroCount == 1 && nums[i] == 0)
                out[i] = fullProduct;
            else
                out[i] = 0;
        
        return out;
    }
}  
