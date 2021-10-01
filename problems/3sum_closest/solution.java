class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        int closest = 0;
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (target == sum)
                    return target;
                int diff;
                if ((diff = Math.abs(target - sum)) < minDiff) {
                    closest = sum;
                    minDiff = diff;
                }
                if (target > sum)
                    l++;
                else r--;
            }
        }
        
        return closest;
    }
}