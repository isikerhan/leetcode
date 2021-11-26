/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            boolean bad = isBadVersion(mid);
            if (bad && !isBadVersion(mid - 1))
                return mid;
            left = bad ? left : mid + 1;
            right = bad ? mid - 1 : right;
        }
        return 1;
    }
}