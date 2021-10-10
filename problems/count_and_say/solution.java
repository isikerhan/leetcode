class Solution {
    public String countAndSay(int n) {
        
        String result = "1";
        
        for (int i = 1; i < n; i++) {
            result = countAndSay(result);
        }   
        
        return result;
    }
    
    public String countAndSay(String s) {
        
        StringBuilder result = new StringBuilder();
        char curr = s.charAt(0);
        int currLen = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == curr) {
                currLen++;
            } else {
                result.append(currLen).append(curr);
                curr = s.charAt(i);
                currLen = 1;
            }
        }
        result.append(currLen).append(curr);
        return result.toString();
    }
}