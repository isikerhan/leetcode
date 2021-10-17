class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n < 2)
            return;
        
        for (int i = 0; i < n / 2; i++) {
            int size = n - 2 * i - 1;
            for (int j = 0; j < size; j++) {
                int temp = matrix[n - i - j - 1][i];
                matrix[n - i - j - 1][i] = matrix[n - i - 1][n - i - j - 1];
                matrix[n - i - 1][n - i - j - 1] = matrix[i + j][n - i - 1];
                matrix[i + j][n - i - 1] = matrix[i][i + j];
                matrix[i][i + j] = temp;
            }
        }
        return;
    }
}