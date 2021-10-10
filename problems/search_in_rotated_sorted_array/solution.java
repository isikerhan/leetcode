class Solution {
    public int search(int[] nums, int target) {    
        int result = search(nums, target, 0, nums.length - 1, false, false, null);
        return result >= 0 ? result : search(nums, target, 0, nums.length - 1, true, false, null);
    }
    
    public int search(int[] nums, int target, int left, int right, boolean inverted, boolean increasing, Integer prevPivotVal) {
        if (right <= left) {
            return nums[left] == target ? left : -1;
        }
        
        int pivot = (left + right) / 2;
        if (nums[pivot] == target)
            return pivot;
        
        if (prevPivotVal != null) {
            if ((increasing && prevPivotVal > nums[pivot]) || (!increasing && prevPivotVal < nums[pivot]))
                inverted = !inverted;
        }
        
        if (nums[pivot] < target ^ inverted)
            return search(nums, target, pivot + 1, right, inverted, true, nums[pivot]);
        else return search(nums, target, left, pivot - 1, inverted, false, nums[pivot]);
    }
}