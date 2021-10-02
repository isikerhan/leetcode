class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        if (s.isEmpty() || words.length == 0)
            return Collections.emptyList();
        
        final List<Integer> indices = new LinkedList<>();
        final int wordLen = words[0].length();
        final int wordCount = words.length;
        final int substrLen = wordLen * wordCount;
        final Map<String, Long> wordsMap = Stream.of(words)
            .collect(Collectors.groupingBy(Function.identity(), TreeMap::new, Collectors.counting()));
                
        for(int i = 0; i < s.length() - wordLen * wordCount + 1; i++) {
            String sub = s.substring(i, i + wordLen * wordCount);
            if (isValidConcatenation(sub, wordLen, wordsMap)) {
                indices.add(i);
            }
        }
        
        return indices;
    }
    
    public boolean isValidConcatenation(String s, int len, Map<String, Long> wordsMap) {
        Map<String, Long> myMap = new HashMap<>(wordsMap);
        for(int i = 0; i < s.length(); i += len) {
            String sub = s.substring(i, i + len);
            Long freq = myMap.get(sub);
            if (freq == null)
                return false;
            if (freq == 1) {
                myMap.remove(sub);
            } else {
                freq--;
                myMap.put(sub, freq);
            }
        }
        return myMap.isEmpty();
    }
}