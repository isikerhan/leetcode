class Solution {
    public String longestCommonPrefix(String[] strs) {
        for(int i = 0; ;i++) {
            boolean same = true;
            Character prev = null;
            for(String str : strs) {
                if (i >= str.length() || (prev != null && prev != str.charAt(i))) {
                    same = false;
                    break;
                }
                prev = str.charAt(i);
            }
            if (!same)
                return strs[0].substring(0, i);
        }
    }
}