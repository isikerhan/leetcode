class Solution {
    public List<String> generateParenthesis(int n) {
        // Create a list to store the combinations
        List<String> combinations = new ArrayList<>();

        // Generate the combinations recursively
        generateParentheses(n, n, "", combinations);

        return combinations;
    }

    public void generateParentheses(int left, int right, String current, List<String> combinations) {
        // If there are no more left and right parentheses to use, add the current combination to the list
        if (left == 0 && right == 0) {
            combinations.add(current);
            return;
        }

        // If there are more left parentheses to use, add one to the current combination
        if (left > 0) {
            generateParentheses(left - 1, right, current + "(", combinations);
        }

        // If there are more right parentheses to use, add one to the current combination
        if (right > 0 && right > left) {
            generateParentheses(left, right - 1, current + ")", combinations);
        }
    }
}