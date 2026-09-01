class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        int[] charCount = new int[26];
        int l = 0;
        int r = 0;

        Arrays.fill(charCount, 0);

        int notMatched = 0;
        char match = 'A';

        while (r < s.length()) {
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

            // int maxCount = 0;
            // int notMatched = 0;
            // char match = '\n';
            // for (int i = 0; i < charCount.length; i++) {
            //     int count = charCount[i];
            //     
            //     if (count > maxCount) {
            //         notMatched += maxCount;
            //         maxCount = count;
            //         match = (char) (i + 'A');
            //     }
// 
            //     else {
            //         notMatched += count;
            //     }
            // }

            while (notMatched > k && l < s.length()) {
                charCount[s.charAt(l) - 'A']--;
                if (s.charAt(l) != match)
                    notMatched--;
                l++;
                
                // needs to change match due to most occured
                // character changing
                for (int i = 0; i < charCount.length; i++) {
                    if (charCount[i] > charCount[match - 'A']) {
                        notMatched -= charCount[i];
                        notMatched += charCount[match - 'A'];
                        match = (char) (i + 'A');
                    }
                }
            }

            maxLen = Math.max(maxLen, 1 + r - l);
            r++;
        }

        return maxLen;
    }
}
