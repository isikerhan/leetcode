class Solution {
    public String longestPalindrome(String s) {
        
        if (s.length() < 2)
            return s;
        
        int len = s.length();
        int center = s.length() / 2;
        String longest = s.substring(0, 1);
        
        for (int i = 0; i < len / 2 + 1; i++) {
            if ((len / 2 - i + 1) * 2 + 1 < longest.length())
                break;
            String current = longest(
                longestPalindrome(s, center + i),
                longestPalindrome(s, center - i),
                longestPalindrome(s, center + i - 0.5),
                longestPalindrome(s, center - i + 0.5)
            );
            if (longest.length() < current.length())
                longest = current;
        }
        
        return longest;
    }
    
    public String longestPalindrome(String s, double center) {
        int i = 1;
        //System.out.println(s);
        //System.out.println(center);
        //System.out.println(i);
        //System.out.println(Math.ceil(center - i));
        //System.out.println(Math.floor(center + i));
        while (((int) Math.ceil(center - i)) >= 0 && ((int) Math.floor(center + i)) < s.length() && s.charAt((int) Math.ceil(center - i)) == s.charAt((int) Math.floor(center + i))) {
            i++;
            //System.out.println("i++:" + i);
        }
        return i > 1 ? s.substring((int) Math.ceil(center - i) + 1, (int) Math.floor(center + i)) : "";
    }
    
    public String longest(String... strings) {
        String longest = "";
        for (String s : strings) {
            if (s.length() > longest.length())
                longest = s;
        }
        return longest;
    }
}