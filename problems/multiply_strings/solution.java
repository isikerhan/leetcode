class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        if (num1.equals("1"))
            return num2;
        if (num2.equals("1"))
            return num1;
        
        if (num1.length() > num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        String result = "0";
        
        for (int i = 0; i < num1.length(); i++) {
            int int1 = num1.charAt(i) - '0';
            int excess = 0;
            StringBuilder innerResult = new StringBuilder();
            for (int j = 0; j < num2.length(); j++) {
                int int2 = num2.charAt(num2.length() - 1 - j) - '0';
                int multiplication = int1 * int2 + excess;
                excess = multiplication / 10;
                innerResult.insert(0, multiplication % 10);
            }
            if (excess > 0)
                innerResult.insert(0, excess);
            innerResult.append("0".repeat(num1.length() - i - 1));
            result = add(result, innerResult.toString());
        }
        return result;     
    }
    
    public String add(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        
        int excess = 0;
        for (int i = 0; i < Math.max(num1.length(), num2.length()); i++) {
            int int1 = num1.length() - i - 1 >= 0 ? num1.charAt(num1.length() - i - 1) - '0' : 0;
            int int2 = num2.length() - i - 1 >= 0 ? num2.charAt(num2.length() - i - 1) - '0' : 0;
            int sum = excess + int1 + int2;
            excess = sum / 10;
            result.insert(0, sum % 10);
        }
        
        if (excess > 0)
            result.insert(0, excess);
        return result.toString();
    }
}