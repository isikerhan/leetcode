class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] original = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int[] result = null;
        
        while(left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                result = new int[]{nums[left], nums[right]};
                break;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        
        return new int[]{indexOf(original, result[0], 0), indexOf(original, result[1], result[0] == result[1] ? 1 : 0)};
    }
    
    public int indexOf(int[] array, int target, int n) {
        
        int order = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target && n == order++) {
                return i;
            }
        }
        
        return -1;
    }
}