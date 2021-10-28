class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        List<int[]> merged = new ArrayList<>(intervals.length);
        merged.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastMerged = merged.get(merged.size() - 1);
            if (current[0] <= lastMerged[1]) {
                lastMerged[1] = Math.max(lastMerged[1], current[1]);
            } else {
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[0][]);
    }
}