class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }
    
    public boolean canJump(int[] nums, int currentPosition) {
        if (currentPosition + nums[currentPosition] >= nums.length - 1)
            return true;
        int jump = nums[currentPosition];
        nums[currentPosition] = 0;
        
        for (int i = jump; i > 0; i--) {
            if (nums[currentPosition + i] > 0 && canJump(nums, currentPosition + i))
                return true;
        }
        return false;
    }
}