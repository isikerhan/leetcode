class Solution {
    public void setZeroes(int[][] matrix) {
        
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 || j == 0) {
                        fr = fr || i == 0;
                        fc = fc || j == 0;
                    } else {
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                setRow(matrix, i);
            }
        }
        
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                setCol(matrix, j);
            }
        }
        
        if (fr)
            setRow(matrix, 0);
        if (fc)
            setCol(matrix, 0);
    }
    
    public void setRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }
    
    public void setCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}