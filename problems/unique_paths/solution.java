class Solution {
    public int uniquePaths(int m, int n) {
        return comb(m + n - 2, n - 1);
    }
    
    public int comb(int n, int r) {
        if (r == 0)
            return 1;
        if (r == 1)
            return n;
        
        if (r < n / 2)
            r = n - r;
        
        long upper = 1;
        long nn = n;
        while (nn > r) {
            upper *= nn;
            nn--;
        }
        
        long lower = 1;
        long rr = n - r;
        while (rr > 1) {
            lower *= rr;
            rr--;
        }
                
        return (int) (upper / lower);
    }
}