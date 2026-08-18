class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[.|/|!|@|#|$|%|^|&|(|)|~|`|[|]|\\{|\\}|=|\\+|_|-|,|\\?|<|>|:|;|\"|\'| ]", "");

        int len = s.length();

        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i))
                return false;
        }

        return true;
    }
}
