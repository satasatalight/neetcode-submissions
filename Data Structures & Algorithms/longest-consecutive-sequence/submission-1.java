class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
            
        HashSet<Integer> numsSet = new HashSet<>(); 
        int longestLen = Integer.MIN_VALUE;

        for (int num : nums) {
            numsSet.add(num);
        }

        for (int num : nums) {
            if (!numsSet.contains(num))
                continue;
            
            numsSet.remove(num);
            
            int curLen = 1;

            int back = num - 1;
            int fwd = num + 1;

            while (numsSet.contains(back)) {
                numsSet.remove(back);
                curLen++;
                back--;
            }

            while (numsSet.contains(fwd)) {
                numsSet.remove(fwd);
                curLen++;
                fwd++;
            }

            longestLen = Math.max(curLen, longestLen);
        }

        return longestLen;
    }
}
