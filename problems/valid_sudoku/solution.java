class Solution {
    public boolean isValidSudoku(char[][] board) {        
        for (int i = 0; i < 9; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] box = new boolean[9];
            for (int j = 0; j < 9; j++) {
                char rowElem = board[i][j];
                char colElem = board[j][i];
                char boxElem = board[(i % 3) * 3 + (j % 3)][(i / 3) * 3 + (j / 3)];
                if (rowElem != '.') {
                    if (row[rowElem - '1'])
                        return false;
                    else row[rowElem - '1'] = true;
                }
                if (colElem != '.') {
                    if (col[colElem - '1'])
                        return false;
                    else col[colElem - '1'] = true;
                }
                if (boxElem != '.') {
                    if (box[boxElem - '1'])
                        return false;
                    else box[boxElem - '1'] = true;
                }
            }
        }
        return true;
    }
}