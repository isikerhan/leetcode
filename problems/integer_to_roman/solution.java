class Solution {
    
    private static final Map<Integer, String> WHOLES = new LinkedHashMap<>() {{
        put(1000, "M");
        put(100, "C");
        put(10, "X");
        put(1, "I");
    }};
            
    private static final Map<Integer, String> HALFS = new HashMap<>() {{
        put(500, "D");
        put(50, "L");
        put(5, "V");
    }};
    
    
    public String intToRoman(int num) {
        if (num == 0)
            return "";
        
        for(int wholeNum : WHOLES.keySet()) {
            if (num < wholeNum)
                continue;
            int division = num / wholeNum;
            int remainder = num % wholeNum;
            String upperSymbol = WHOLES.get(wholeNum * 10);
            String upperHalfSymbol = HALFS.get(wholeNum * 5);
            String symbol = WHOLES.get(wholeNum);
            return getRoman(division, upperSymbol, upperHalfSymbol, symbol) + intToRoman(remainder);
        }
        return "";
    }
            
    public String getRoman(int number, String upper, String upperHalf, String curr) {
        if (number < 4) {
            return curr.repeat(number);
        } 
        if (number < 6) {
            return curr.repeat(5 - number) + upperHalf;
        }
        if (number < 9) {
            return upperHalf + curr.repeat(number - 5);
        }
        return curr.repeat(10 - number) + upper;
    }
}