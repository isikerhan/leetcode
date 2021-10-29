class Solution {
      
    public boolean isNumber(String s) {
        // decimal number: [+-]?(\\d+\\.|\\d+\\.\\d+|\\.\\d+)
        // integer: [+-]?(\\d+)
        // valid number: (decimal number|integer)([eE]integer)?
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("([+-]?(\\d+\\.|\\d+\\.\\d+|\\.\\d+)|[+-]?(\\d+))([eE][+-]?(\\d+))?");
        return pattern.matcher(s).matches();
    }
}