class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder result = new StringBuilder();
        boolean excess = false;
        
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            short first = (short) (i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0);
            short second = (short) (i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0);
            short sum = (short) ((excess ? 1 : 0) + first + second);
            excess = sum / 2 > 0;
            result.append(sum % 2);
        }
        
        if (excess)
            result.append(1);
        
        return result.reverse().toString();
    }
}