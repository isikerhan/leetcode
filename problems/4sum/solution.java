class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        outer:
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] * 4 > target)
                break;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if ((nums[i] + nums[j]) * 2 > target)
                    break;
                int localTarget = target - nums[i] - nums[j];
                int right = nums.length - 1, left = j + 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum == localTarget) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;
                    } else if (sum < localTarget) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}