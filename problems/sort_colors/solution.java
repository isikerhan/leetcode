class Solution {
    public void sortColors(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
    
    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    public void merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1;
        
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                // shift j to k
                for (int shift = j; shift > i; shift--)
                    swap(arr, shift, shift - 1);
                j++;
                mid++;
            }
            i++;
        }
    }
    
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}