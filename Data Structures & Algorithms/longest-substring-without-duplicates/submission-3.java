class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> seen = new HashSet<>();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        for (r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);

            while (seen.contains(cur)) {
                seen.remove(s.charAt(l));
                l++;
            }

            seen.add(cur);
            maxLen = Math.max(maxLen, (r - l) + 1);
        }

        return maxLen;
    }
}
