class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int notMatched = 0;
        char match = 'A';

        int[] charCount = new int[26];
        Arrays.fill(charCount, 0);

        int l = 0;
        int r = 0;

        for (r = 0; r < s.length(); r++) {
            char cur = s.charAt(r);

            charCount[cur - 'A']++;

            if (cur != match) {
                notMatched++;

                if (charCount[cur - 'A'] > charCount[match - 'A']) {
                    notMatched -= charCount[cur - 'A'];
                    notMatched += charCount[match - 'A'];
                    match = cur;
                }
            }

            while (notMatched > k && l < s.length()) {
                charCount[s.charAt(l) - 'A']--;

                if (s.charAt(l) != match)
                    notMatched--;
                
                // may need to change match due to most occured
                // character changing
                else {
                    for (int i = 0; i < charCount.length; i++) {
                        if (charCount[i] > charCount[match - 'A']) {
                            notMatched -= charCount[i];
                            notMatched += charCount[match - 'A'];
                            match = (char) (i + 'A');
                        }
                    }
                }

                l++;
            }

            maxLen = Math.max(maxLen, 1 + r - l);
        }

        return maxLen;
    }
}
