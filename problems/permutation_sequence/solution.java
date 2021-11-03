class Solution {
    public String getPermutation(int n, int k) {
        int[] factorial = getFactorials(n - 1);
        List<Integer> numbers = getNumbers(n);
        StringBuilder result = new StringBuilder();
            
        getPermutation(numbers, k - 1, factorial, result);
        return result.toString();
    }
    
    public void getPermutation(List<Integer> numbers, int k, int[] factorial, StringBuilder result) {
        if (numbers.size() == 1) {
            result.append(numbers.remove(0));
            return;
        }
        
        int divider = factorial[numbers.size() - 1];
        int index = k / divider;
        int number = numbers.remove(index);
        result.append(number);
        getPermutation(numbers, k % divider, factorial, result);
    }
    
    public int[] getFactorials(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] * i;
        }
        return result;
    }
    
    public List<Integer> getNumbers(int n) {
        List<Integer> result = new ArrayList();
        
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }
        
        return result;
    }
}