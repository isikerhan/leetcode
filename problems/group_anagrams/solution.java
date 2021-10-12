class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagramsMap = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String sorted = sort(strs[i]);
            List<String> list = anagramsMap.computeIfAbsent(sorted, k -> new LinkedList<>());
            list.add(strs[i]);
        }
        
        return new ArrayList<>(anagramsMap.values());
    }
    
    public String sort(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}