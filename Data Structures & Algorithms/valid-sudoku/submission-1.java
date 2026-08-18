class Solution {
    public boolean isValidSudoku(char[][] board) {
        ArrayList<HashSet<Character>> hashRows = new ArrayList<>(9);
        ArrayList<HashSet<Character>> hashCols = new ArrayList<>(9);
        ArrayList<HashSet<Character>> hashBoxes = new ArrayList<>(9);

        // fill arrays 
        for (int i = 0; i < 9; i++) {
            hashRows.add(new HashSet<Character>());
            hashCols.add(new HashSet<Character>());
            hashBoxes.add(new HashSet<Character>());
        }

        for (int row = 0; row < 9; row++) {
            HashSet<Character> curRow = hashRows.get(row);

            for (int col = 0; col < 9; col++) {
                char cur = board[row][col];

                if (cur == '.')
                    continue;

                int box = ((row / 3) * 3) + (col / 3);
                HashSet<Character> curBox = hashBoxes.get(box);
                HashSet<Character> curCol = hashCols.get(col);

                if (curCol.contains(cur) || curRow.contains(cur) || curBox.contains(cur))
                    return false;
                
                curCol.add(cur);
                curBox.add(cur);
                curRow.add(cur);

                hashCols.set(col, curCol);
                hashBoxes.set(box, curBox);
            }

            hashRows.set(row, curRow);
        }

        return true;
    }
}
