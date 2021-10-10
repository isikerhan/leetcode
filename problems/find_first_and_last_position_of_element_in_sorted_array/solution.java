class Solution {
    public int[] searchRange(int[] nums, int target) {       
        int firstIndex = binarySearch(nums, target, 0, nums.length - 1, -1, true);
        if (firstIndex == -1)
            return new int[] {-1, -1};
        return new int[] {firstIndex, binarySearch(nums, target, 0, nums.length - 1, -1, false)};
    }
    
    public int binarySearch(int[] nums, int target, int left, int right, int lastFound, boolean firstIndex) {
        if (right >= left) {
            int pivot = (right + left) / 2;
            if (nums[pivot] == target)
                lastFound = pivot;
            if (target > nums[pivot] || (nums[pivot] == target && !firstIndex))
                return binarySearch(nums, target, pivot + 1, right, lastFound, firstIndex);
            return binarySearch(nums, target, left, pivot - 1, lastFound, firstIndex);
        }
        return lastFound;
    }
}