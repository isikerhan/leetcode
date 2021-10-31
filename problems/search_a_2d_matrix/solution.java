class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixIndex = binarySearch(matrix, 0, matrix.length - 1, target);
        if (matrixIndex < 0)
            return false;
        return binarySearch(matrix[matrixIndex], 0, matrix[matrixIndex].length - 1, target) >= 0;
    }

    public int binarySearch(int[][] matrix, int left, int right, int target) {
        if (left <= right) {
            int pivot = left + (right - left) / 2;
            if (matrix[pivot][0] > target) {
                return binarySearch(matrix, left, pivot - 1, target);
            } else if (matrix[pivot][matrix[pivot].length - 1] < target) {
                return binarySearch(matrix, pivot + 1, right, target);
            } else return pivot;
        }
        return -1;
    }

    public int binarySearch(int[] arr, int left, int right, int target) {
        if (left <= right) {
            int pivot = left + (right - left) / 2;
            if (arr[pivot] > target) {
                return binarySearch(arr, left, pivot - 1, target);
            } else if (arr[pivot] < target) {
                return binarySearch(arr, pivot + 1, right, target);
            } else return pivot;
        }
        return -1;
    }
}