class Solution {
    
    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return Collections.emptyList();
        
        List<String> combinations = new LinkedList<>();
        combs(digits.length(), 0, digits, new StringBuilder(), combinations);
        return combinations;
    }
    
    public void combs(int maxLen, int index, String digits, StringBuilder curr, List<String> combs) {
        
        if (curr.length() == maxLen) {
            combs.add(curr.toString());
            return;
        }
        
        for (char c : toLetters(digits.charAt(index))) {
            curr.append(c);
            combs(maxLen, index + 1, digits, curr, combs);
            curr.setLength(curr.length() - 1);
        }
    }
    
    public char[] toLetters(char digit) {
        switch(digit) {
            case '2': return new char[] {'a', 'b', 'c', };
            case '3': return new char[] {'d', 'e', 'f', };
            case '4': return new char[] {'g', 'h', 'i', };
            case '5': return new char[] {'j', 'k', 'l', };
            case '6': return new char[] {'m', 'n', 'o', };
            case '7': return new char[] {'p', 'q', 'r', 's'};
            case '8': return new char[] {'t', 'u', 'v', };
            case '9': return new char[] {'w', 'x', 'y', 'z'};
            default: return null;
        }
    }
}