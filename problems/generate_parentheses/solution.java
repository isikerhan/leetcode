class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        generate(result, new StringBuilder(), n, 0, n * 2);
        return result;
    }
    
    public void generate(List<String> result, StringBuilder current, int remainingOpen, int remainingClose, int maxLen) {
        if (current.length() == maxLen) {
            result.add(current.toString());
            return;
        }
        
        if (remainingOpen > 0) {
            int lenBefore = current.length();
            current.append('(');
            generate(result, current, remainingOpen - 1, remainingClose + 1, maxLen);
            current.setLength(lenBefore);
        }
        
        if (remainingClose > 0) {
            int lenBefore = current.length();
            current.append(')');
            generate(result, current, remainingOpen, remainingClose - 1, maxLen);
            current.setLength(lenBefore);
        }
    }
}