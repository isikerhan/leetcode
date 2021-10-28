class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0)
                    continue;
                int minNeighbor = minNeighbor(grid, i, j);
                grid[i][j] += minNeighbor;
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
    
    public int minNeighbor(int[][] grid, int i, int j) {
        return Math.min(i == 0 ? Integer.MAX_VALUE : grid[i - 1][j], j == 0 ? Integer.MAX_VALUE : grid[i][j - 1]);
    }
}