class Solution {
    public int strStr(String haystack, String needle) {
        
        if ("".equals(needle))
            return 0;
        if (haystack.equals(needle))
            return 0;
        
        int pos = -1;
        for(int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}