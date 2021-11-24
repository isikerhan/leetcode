class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            
            boolean cont = false;
            
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                cont = true;
            }
            
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                cont = true;
            }
            
            if (cont) continue;
            
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}