class Solution {
    public int mySqrt(int x) {
        if (x < 2)
            return x;
        int sqrt = 1;
        while ((long) sqrt * sqrt <= x) {
            sqrt++;
        }
        return sqrt - 1;
    }
}