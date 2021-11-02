class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int zeroCnt = 0;
        int zeroIndex = -1;
        int mult = 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex = i;
                if (++zeroCnt > 1)
                    break;
            }
            else mult *= nums[i];
        }
        
        int[] result = new int[nums.length];
        
        if (zeroCnt > 1)
            return result;
        if (zeroIndex >= 0) {
            result[zeroIndex] = mult;
            return result;
        }
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) (Math.pow(nums[i], -1) * mult);
        }
        return result;
    }
}