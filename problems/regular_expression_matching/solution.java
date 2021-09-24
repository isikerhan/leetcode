class Solution {
    public boolean isMatch(String s, String p) {
        return java.util.regex.Pattern.compile(p).matcher(s).matches();
    }
}