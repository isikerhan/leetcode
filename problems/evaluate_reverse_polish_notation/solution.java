class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":{
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(num1 + num2);
                    break;
                }
                case "-":{
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(num1 - num2);
                    break;
                }
                case "*":{
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(num1 * num2);
                    break;
                }
                case "/":{
                    int num2 = stack.pop(), num1 = stack.pop();
                    stack.push(num1 / num2);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}