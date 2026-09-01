class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length() - 1;

        int[] source = new int[26];
        Arrays.fill(source, 0);

        for (char s : s1.toCharArray())
            source[s - 'a']++;
        
        int[] compare = new int[26];
        Arrays.fill(compare, 0);

        for (int i = 0; i < window; i++)
            compare[s2.charAt(i) - 'a']++;

        for (int i = 0; i + window < s2.length(); i++) {
            compare[s2.charAt(i + window) - 'a']++;

            boolean equal = true;
            for (int j = 0; j < 26; j++) {
                if (compare[j] != source[j]) {
                    equal = false;
                    break;
                }
            }

            if (equal)
                return true;

            compare[s2.charAt(i) - 'a']--;
        }
        
        return false;
    }
}
