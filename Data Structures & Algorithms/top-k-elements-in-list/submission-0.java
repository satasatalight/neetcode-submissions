class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // value, count
        HashMap<Integer, Integer> freq = new HashMap<>();

        // fill hashmap
        for (int num : nums) {
            int c = freq.getOrDefault(num, 0);
            freq.put(num, c + 1);
        }

        // convert to arraylist
        ArrayList<Map.Entry<Integer, Integer>> freqArr = new ArrayList<>(freq.entrySet());

        // sort ascending to descending
        Collections.sort(freqArr, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        // fill result array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = freqArr.get(i).getKey();
        }
        return res;
    }
}
