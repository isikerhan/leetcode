class Solution {
    public int minStartValue(int[] nums) {
        int sum = 0;
        int minSum = Integer.MAX_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum < minSum) {
                minSum = sum;
            }
        }
        
        return Math.max(1 - minSum, 1);
    }
}