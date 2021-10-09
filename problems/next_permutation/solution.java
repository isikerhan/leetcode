class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        
        int swapIndex = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                swapIndex = i;
                break;
            }
        }
        
        if (swapIndex > 0) {
            int minIndex = indexOfMinGt(nums[swapIndex - 1], nums, swapIndex, nums.length);
            swap(nums, swapIndex - 1, minIndex);
        }
        reverse(nums, swapIndex, nums.length - 1);
    }
    
    public void reverse(int[] nums, int left, int right) {
        while(left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    public int indexOfMinGt(int gt, int[] nums, int start, int end) {
        for (int i = end - 1; i >= start; i--) {
            if (nums[i] > gt) {
                return i;
            }
        }
        return -1;
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}