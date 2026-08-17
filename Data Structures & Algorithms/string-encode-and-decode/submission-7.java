class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (int i = 0; i < strs.size(); i++)
            res += strs.get(i) + '\n';
        System.out.println("encode: " + res);
        return res;
    }

    public List<String> decode(String str) {
        if (str.isEmpty())
            return new ArrayList<>();

        ArrayList<String> res = new ArrayList<>();
        res.add("");

        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);

            if (c == '\n') {
                res.add("");
                continue;
            }

            int index = res.size() - 1;
            String strRes = res.get(index);

            strRes += c;
            res.set(index, strRes);
        }

        return res;
    }
}
