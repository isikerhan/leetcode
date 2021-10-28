class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int[][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] line : mem)
            Arrays.fill(line, -1);
        return paths(obstacleGrid, 0, 0, mem);
    }
    
    public int paths(int[][] grid, int row, int col, int[][] mem) {
        if (mem[row][col] >= 0)
            return mem[row][col];
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            return 1 - grid[row][col];
        }
        int pathCount = 0;
        if (canMove(grid, row, col, true))
            pathCount += paths(grid, row, col + 1, mem);
        if (canMove(grid, row, col, false))
            pathCount += paths(grid, row + 1, col, mem);
        mem[row][col] = pathCount;
        return pathCount;
    }
    
    boolean canMove(int[][] grid, int row, int col, boolean horizontal) {
        if (horizontal) {
            return col + 1 < grid[0].length && grid[row][col + 1] == 0;
        } else {
            return row + 1 < grid.length && grid[row + 1][col] == 0;
        }
    }
}