class Solution {
    public int[] plusOne(int[] digits) {
        
        int numToAdd = 1;
        for (int i = digits.length - 1; i >=0 ; i--) {
            if (numToAdd == 0)
                break;
            digits[i] += numToAdd;
            numToAdd = digits[i] / 10;
            digits[i] %= 10;
        }
        
        if (numToAdd > 0) {
            int[] oldDigits = digits;
            digits = new int[digits.length + 1];
            digits[0] = numToAdd;
            System.arraycopy(oldDigits, 0, digits, 1, oldDigits.length);
        }
        return digits;
    }
}