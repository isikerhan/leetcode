class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() < 2)
            return "";
        
        for(int i = 0; i < palindrome.length(); i++) {
            if (palindrome.length() % 2 == 1 && i == palindrome.length() / 2)
                continue;
            if (palindrome.charAt(i) != 'a') {
                return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
            }
        }
        
        return palindrome.substring(0, palindrome.length() - 1) + "b";
    }
}