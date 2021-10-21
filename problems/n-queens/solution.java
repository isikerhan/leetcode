class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        nQueens(new ArrayList<>(n), n, result);
        return result;
    }
    
    public void nQueens(List<Integer> queens, int n, List<List<String>> result) {
        
        if (queens.size() == n) {
            result.add(queensToBoard(queens, n));
            return;
        }
        
        int row = queens.size();
        for (int col = 0; col < n; col++) {
            if (canBeAttacked(row, col, queens, n)) {
                continue;
            }
            queens.add(col);
            nQueens(queens, n, result);
            queens.remove(queens.size() - 1);
        }
    }
    
    public boolean canBeAttacked(int row, int col, List<Integer> queens, int n) {
        
        for (int i = 0; i < queens.size(); i++) {
            if (queens.get(i) == col || i - queens.get(i) == row - col || i + queens.get(i) == row + col)
                return true;
        }
        
        return false;
    }
    
    public List<String> queensToBoard(List<Integer> queens, int n) {
        List<String> board = new ArrayList<>(queens.size());
        for (int queen : queens) {
            board.add(".".repeat(queen) + "Q" + ".".repeat(n - queen - 1));
        }
        return board;
    }
}