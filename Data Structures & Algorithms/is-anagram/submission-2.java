class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
            
        HashMap<Character, Integer> sCount = new HashMap<>();
        HashMap<Character, Integer> tCount = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = sCount.getOrDefault(c, 0);
            sCount.put(c, count + 1);
        }

        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            int count = tCount.getOrDefault(c, 0);
            tCount.put(c, count + 1);
        }

        return sCount.equals(tCount);
    }
}
