class Solution {
    public double myPow(double x, int n) {
        if (n == 0)
            return 1D;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        double powHalf = myPow(x, n / 2);
        return myPow(x, n % 2) * powHalf * powHalf;
    }
}