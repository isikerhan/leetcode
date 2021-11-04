class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        combine(result, new ArrayList<>(), 1, n, k);
        return result;
    }
    
    public void combine(List<List<Integer>> result, List<Integer> current, int currIndex, int n, int k) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = currIndex; i <= n - (k - current.size() - 1); i++) {
            current.add(i);
            combine(result, current, i + 1, n, k);
            current.remove(current.size() - 1);
        }
    }
}