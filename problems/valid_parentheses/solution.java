class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Character opening = getOpeningParenthesisOf(c);
            if (opening == null)
                stack.push(c);
            else if(stack.isEmpty() || stack.pop() != opening)
                return false;
        }
        return stack.isEmpty();
    }
    
    public Character getOpeningParenthesisOf(char c) {
        switch(c) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return null;
        }  
    }
}