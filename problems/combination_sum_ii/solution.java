class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();
        combinationSum(candidates, target, new LinkedList<>(), 0, 0, result);
        return result;
    }
    
    public void combinationSum(int[] candidates, int target, List<Integer> current, int currentSum, int currentIndex, List<List<Integer>> result) {
        
        if (currentSum == target) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = currentIndex; i < candidates.length; i++) {
            if (currentSum + candidates[i] > target)
                break;
            if (i > currentIndex && candidates[i] == candidates[i - 1])
                continue;
            current.add(candidates[i]);
            combinationSum(candidates, target, current, currentSum + candidates[i], i + 1, result);
            current.remove(current.size() - 1);
        }
    }
}