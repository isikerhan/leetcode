class Solution {
    public int myAtoi(String s) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("((\\+|-)?\\d+).*").matcher(s.trim());
        if (!matcher.matches())
            return 0;
        String numberAsStr = matcher.group(1);
        java.math.BigDecimal bd = new java.math.BigDecimal(numberAsStr);
        return bd.compareTo(java.math.BigDecimal.valueOf(Integer.MIN_VALUE)) < 0 ? Integer.MIN_VALUE : bd.compareTo(java.math.BigDecimal.valueOf(Integer.MAX_VALUE)) > 0 ? Integer.MAX_VALUE : bd.intValue();
    }
}