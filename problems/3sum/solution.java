class Solution {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int num = nums[i];
            Map<Integer, List<Integer>> sums = new LinkedHashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (sums.containsKey(-nums[j])) {
                    List<Integer> integers = new ArrayList<>(sums.get(-nums[j]));
                    integers.add(nums[j]);
                    result.add(integers);
                } else {
                    sums.put(num + nums[j], new ArrayList<>(Arrays.asList(num, nums[j])));
                }
            }
        }
        return new ArrayList<>(result);
    }
}