class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int shift = 0;
        int prev = nums[0];
        for(int i = 1; i < len; i++) {
            if (prev == nums[i]) {
                shift++;
            } else {
                nums[i - shift] = nums[i];
            }
            prev = nums[i];
        }
        return len - shift;
    }
}