class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> used = new HashSet<>();

        for (int num : nums) {
            if (used.contains(num))
                return true;
            used.add(num);
        }

        return false;
    }
}