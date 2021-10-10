class Solution {
    
    public int divide(int iDividend, int iDivisor) {
        
        if (iDividend == 0)
            return 0;
        if (iDivisor == 1)
            return iDividend;
        if (iDivisor == -1)
            return (int) Math.max(Integer.MIN_VALUE, Math.min(0L - iDividend, Integer.MAX_VALUE));
        
        boolean negative = iDividend < 0 && iDivisor > 0 || iDividend > 0 && iDivisor < 0;
        long dividend = iDividend < 0 ? 0L - iDividend : iDividend;
        long divisor = iDivisor < 0 ? 0L - iDivisor : iDivisor;
        
        System.out.println(dividend + ", "+ divisor);
        
        long result = 0, curr = 0;
        long tempDivisor = divisor, tempCnt = 1;
        
        while (curr + divisor <= dividend) {
            System.out.println(curr + ", " + dividend + ", " + tempDivisor);
            if (curr + tempDivisor > dividend) {
                tempDivisor = divisor;
                tempCnt = 1;
            }
            curr += tempDivisor;
            result += tempCnt;
            tempDivisor <<= 1;
            tempCnt <<= 1;
        }
        
        result =  negative ? 0 - result : result;
        return (int) Math.max(Integer.MIN_VALUE, Math.min(result, Integer.MAX_VALUE));
    }
}