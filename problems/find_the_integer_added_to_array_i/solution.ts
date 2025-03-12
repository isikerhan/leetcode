function addedInteger(nums1: number[], nums2: number[]): number {
  let min1 = nums1[0];
  for (let i = 1; i < nums1.length; i++) {
    if (nums1[i] < min1) {
      min1 = nums1[i];
    }
  }

  let min2 = nums2[0];
  for (let i = 1; i < nums2.length; i++) {
    if (nums2[i] < min2) {
      min2 = nums2[i];
    }
  }

  return min2 - min1;
};
