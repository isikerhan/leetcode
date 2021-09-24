class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return findMedian(nums2);
        else if (nums2.length == 0)
            return findMedian(nums1);

        int totalLen = nums1.length + nums2.length;
        int cur1 = 0, cur2 = 0;
        int curr = 0;
        int prev = 0;
        for (int i = 0; i <= totalLen / 2; i++) {
            prev = curr;
            if (cur1 == nums1.length) {
                curr = nums2[cur2];
                cur2++;
            } else if (cur2 == nums2.length) {
                curr = nums1[cur1];
                cur1++;
            } else if (nums1[cur1] < nums2[cur2]) {
                curr = nums1[cur1];
                cur1++;
            } else {
                curr = nums2[cur2];
                cur2++;
            }
        }
        return totalLen % 2 == 0 ? (double) (curr + prev) / 2 : curr;
    }
    
    public double findMedian(int[] nums) {
        double result = nums[nums.length / 2];
        if (nums.length % 2 == 0) {
            result += nums[nums.length / 2 - 1];
            result /= 2;
        }
        return result;
    }
}