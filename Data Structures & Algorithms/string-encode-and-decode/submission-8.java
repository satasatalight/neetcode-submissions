class Solution {

    public String encode(List<String> strs) {
        String res = "";

        for (int i = 0; i < strs.size(); i++)
            res += strs.get(i) + '\n';

        return res;
    }

    public List<String> decode(String str) {
        Stack<String> res = new Stack<>();

        if (str.isEmpty())
            return res;

        String cur = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '\n') {
                res.push(cur);
                cur = "";
                continue;
            }

            cur += c;
        }

        return res;
    }
}
