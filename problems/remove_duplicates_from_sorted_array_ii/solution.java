class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int prev = nums[0];
        int currOccurrence = 1;
        int shift = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                currOccurrence++;
                if (currOccurrence > 2)
                    shift++;
            } else {
                prev = nums[i];
                currOccurrence = 1;
            }
            nums[i - shift] = nums[i];
        }
        return nums.length - shift;
    }
}