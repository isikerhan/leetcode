class Solution {
    public int reverse(int x) {
        try {
            boolean negative = x < 0;
            return (negative ? -1 : 1) * Integer.parseInt(new StringBuilder().append(negative ? -x : x).reverse().toString());
        } catch (Exception e) {
            return 0;
        }
    }
}