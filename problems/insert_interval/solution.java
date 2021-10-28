class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int pos = intervals.length;
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] < intervals[i][0]) {
                pos = i;
                break;
            }
        }
        
        int[] merged = newInterval;
        if (pos > 0 && intervals[pos - 1][1] >= newInterval[0]) {
            merged[0] = intervals[pos - 1][0];
            pos--;
        }
        
        int end = pos;
        while (end < intervals.length && intervals[end][0] <= merged[1]) {
            merged[1] = Math.max(intervals[end][1], merged[1]);
            end++;
        }
        
        List<int[]> result = new LinkedList<>();
        result.addAll(Arrays.asList(Arrays.copyOfRange(intervals, 0, pos)));
        result.add(merged);
        result.addAll(Arrays.asList(Arrays.copyOfRange(intervals, end, intervals.length)));
        return result.toArray(new int[0][]);
    }
}