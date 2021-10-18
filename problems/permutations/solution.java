class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        permute(nums, 0, result);
        return result;
    }
    
    public void permute(int[] nums, int currentIndex, List<List<Integer>> result) {
        if (currentIndex == nums.length) {
            List<Integer> currentResult = new ArrayList<>(nums.length);
            for (int num : nums) {
                currentResult.add(num);
            }
            result.add(currentResult);
            return;
        }
        
        for (int i = currentIndex; i < nums.length; i++) {
            swap(nums, currentIndex, i);
            permute(nums, currentIndex + 1, result);
            swap(nums, currentIndex, i);
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}