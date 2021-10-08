class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
    
    public int search(int[] nums, int target, int left, int right) {
        int pivot = (left + right) / 2;
        
        if (nums[pivot] == target) {
            return pivot;
        }
        
        if (left >= right) {
            return target < nums[pivot] ? pivot : pivot + 1;
        }
        
        return target < nums[pivot] ? search(nums, target, left, pivot - 1)
            : search(nums, target, pivot + 1, right);
    }
}