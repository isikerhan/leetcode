class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 1; i <= nums.length; i++) {
            set.add(i);
        }
        
        for (int i = 0; i < nums.length; i++) {
            set.remove(nums[i]);
        }
        
        return new ArrayList<>(set);
    }
}