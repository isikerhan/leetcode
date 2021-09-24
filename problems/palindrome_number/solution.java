class Solution {
    public boolean isPalindrome(int x) {
        String strVal = Integer.toString(x);
        return new StringBuilder(strVal).reverse().toString().equals(strVal);
    }
}