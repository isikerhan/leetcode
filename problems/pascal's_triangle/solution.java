class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        
        for (int i = 1; i < numRows; i++) {
            int size = i + 1;
            List<Integer> prevRow = result.get(result.size() - 1);
            List<Integer> currentRow = new ArrayList<>(size);
            currentRow.add(1);
            for (int j = 0; j < size - 2; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            currentRow.add(1);
            result.add(currentRow);
        }
        
        return result;
    }
}