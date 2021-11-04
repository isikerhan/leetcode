class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        subsets(result, new LinkedList<>(), nums, 0);
        return result;
    }
    
    public void subsets(List<List<Integer>> result, List<Integer> curr, int[] nums, int currIndex) {
        if (currIndex == nums.length + 1) {
            return;
        }
        
        result.add(new ArrayList<>(curr));
        
        for (int i = currIndex; i < nums.length; i++) {
            curr.add(nums[i]);
            subsets(result, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}