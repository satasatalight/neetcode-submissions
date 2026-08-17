class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> sublists = new HashMap<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = String.valueOf(arr);

            ArrayList<String> list = sublists.getOrDefault(sorted, new ArrayList<String>());
            list.add(str);
            sublists.put(sorted, list);
        }

        return new ArrayList(sublists.values());
    }
}
