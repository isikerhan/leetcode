class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permuteUnique(nums, 0, result);
        return result;
    }
    
    public void permuteUnique(int[] nums, int currentIndex, List<List<Integer>> result) {
        if (currentIndex == nums.length) {
            List<Integer> currentResult = new ArrayList<>(nums.length);
            for (int num : nums) {
                currentResult.add(num);
            }
            result.add(currentResult);
            return;
        }
        
        Set<Integer> picked = new HashSet<>();
        for (int i = currentIndex; i < nums.length; i++) {
            if (picked.contains(nums[i]))
                continue;
            swap(nums, currentIndex, i);
            permuteUnique(nums, currentIndex + 1, result);
            swap(nums, currentIndex, i);

            picked.add(nums[i]);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}