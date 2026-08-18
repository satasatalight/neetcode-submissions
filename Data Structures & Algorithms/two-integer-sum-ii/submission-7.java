class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashSet<Integer> searched = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            int search = target - numbers[i];

            if (searched.contains(search))
                continue;

            for (int j = 0; j < numbers.length; j++) {
                if (i == j)
                    continue;

                // int found = Arrays.binarySearch(numbers, search);
                int found;

                // edge case, searched value is equal to self
                if (search == numbers[i]) {
                    if (numbers[i + 1] == search)
                        return new int[] {i + 1, i + 2};
                    else
                        continue;
                }

                else if (search > numbers[i])
                    found = Arrays.binarySearch(numbers, i + 1, numbers.length, search);

                else 
                    found = Arrays.binarySearch(numbers, 0, i, search);

                if (found >= 0 && numbers[found] == search)
                    return new int[] {i + 1, found + 1};
            }

            searched.add(search);
        }

        return null;
    }
}
