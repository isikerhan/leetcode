class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int i = 0;
        List<String> lines = new LinkedList<>();
        while (i < words.length) {
            List<String> currentWords = new LinkedList<>();
            int currLen = 0;
            while (i < words.length && currLen + currentWords.size() - 1 + words[i].length() < maxWidth) {
                currentWords.add(words[i]);
                currLen += words[i].length();
                i++;
            }
            
            StringBuilder line = new StringBuilder();
            if (i == words.length) {
                line.append(String.join(" ", currentWords));
            } else {
                List<String> spaces = getSpaces(currentWords.size() - 1, maxWidth - currLen);
                for (int j = 0; j < currentWords.size(); j++) {
                    line.append(currentWords.get(j));
                    if (j < currentWords.size() - 1)
                        line.append(spaces.get(j));
                }
            }
            
            if (line.length() < maxWidth)
                line.append(" ".repeat(maxWidth - line.length()));
            lines.add(line.toString());
        }
        return lines;
    }
    
    public List<String> getSpaces(int count, int totalWidth) {
        if (count == 0)
            return new ArrayList<>();
        AtomicInteger excess = new AtomicInteger(totalWidth % count);
        return IntStream.generate(() -> totalWidth / count)
            .limit(count)
            .map(i -> excess.getAndDecrement() > 0 ? i + 1 : i)
            .mapToObj(i -> " ".repeat(i))
            .collect(Collectors.toList());
    }
}