class Solution {
    public int romanToInt(String s) {
        // Define a map of Roman numeral characters to their corresponding integer values
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        // Initialize the result to 0
        int result = 0;

        // Iterate over the characters in the string
        for (int i = 0; i < s.length(); i++) {
            // Get the current and next characters
            char current = s.charAt(i);
            char next = i < s.length() - 1 ? s.charAt(i + 1) : '\0';

            // If the current character has a lower value than the next character, subtract its value
            // from the result. Otherwise, add its value to the result.
            if (current == 'I' && (next == 'V' || next == 'X')) {
                result -= romanMap.get(current);
            } else if (current == 'X' && (next == 'L' || next == 'C')) {
                result -= romanMap.get(current);
            } else if (current == 'C' && (next == 'D' || next == 'M')) {
                result -= romanMap.get(current);
            } else {
                result += romanMap.get(current);
            }
        }

        return result;
    }
}