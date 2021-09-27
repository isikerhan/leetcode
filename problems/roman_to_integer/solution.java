class Solution {
    
    private static final Map<Character, Integer> NUMERALS = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );
    
    public int romanToInt(String s) {
        int result = 0;
        int len = s.length();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            int value = NUMERALS.get(c);
            if (i < len - 1 && value < NUMERALS.get(s.charAt(i + 1))) {
                value *= -1;
            }
            result += value;
        }
        return result;
    }
}