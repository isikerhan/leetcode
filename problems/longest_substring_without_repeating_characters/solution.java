class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        int start = 0;
        int end = 0;
        int max = 0;
        Map<Character, Integer> chars = new HashMap<>();
        chars.put(s.charAt(0), 0);
        for (int i = 1; i < len; i++) {
            Character c = s.charAt(i);
            if (chars.containsKey(c)) {
                start = chars.get(c) + 1;
                final int removeBefore = start;
                chars.values().removeIf(pos -> pos < removeBefore);
            }
            end = i;
            int currLen = end - start + 1;
            if (currLen > max) {
                max = currLen;
            }
            chars.put(c, i);
            if (len - start + 1 < max)
                break;
        }
        return max;
    }
}