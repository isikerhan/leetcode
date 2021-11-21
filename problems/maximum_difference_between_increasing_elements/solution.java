class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int maxDiff = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min)
                min = nums[i];
            int diff = nums[i] - min;
            if (diff > maxDiff) {
                maxDiff = diff;
            }
        }
        
        return maxDiff == 0 ? -1 : maxDiff;
    }
}