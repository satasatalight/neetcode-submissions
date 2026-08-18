class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                
                if (!validRow(board[i], j) || !validColumn(board, i, j) || !validBox(board, i, j))
                    return false;
            }
        }

        return true;
    }

    public boolean validRow(char[] row, int j) {
        char cur = row[j];

        for (int k = j + 1; k < j + 9; k++) {
            if (cur == row[k % 9])
                return false;
        }

        return true;
    }

    public boolean validColumn(char[][] board, int i, int j) {
        char cur = board[i][j];

        for (int k = i + 1; k < i + 9; k++) {
            if (cur == board[k % 9][j])
                return false;
        }

        return true;
    }

    public boolean validBox(char[][] board, int i, int j) {
        char cur = board[i][j];

        int startK = (i / 3) * 3;
        int startL = (j / 3) * 3;

        for (int k = startK; k < startK + 3; k++) {
            for (int l = startL; l < startL + 3; l++) {
                if (k == i && l == j)
                    continue;
                if (board[k][l] == cur)
                    return false;
            }
        }


        return true;
    }
}
