class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            Integer count = map.get(c);
            map.put(c, count == null ? 1 : ++count);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            Integer count = map.get(c);
            if (count == null || count < 1)
                return false;
            map.put(c, --count);
        }
        
        return true;
    }
}