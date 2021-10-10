class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            current.add(candidates[i]);
            combinationSum(candidates, target, current, currentSum + candidates[i], i, result);
            current.remove(current.size() - 1);
        }
    }
}