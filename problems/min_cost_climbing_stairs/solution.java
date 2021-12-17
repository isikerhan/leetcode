class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] result = new int[cost.length];
        result[0] = cost[0];
        result[1] = cost[1];
        
        // [1,100,1,1,1,100,1,1,100,1]
        for (int i = 2; i < cost.length; i++) {
            result[i] = cost[i] + Math.min(result[i - 1], result[i - 2]);
        }
        
        return Math.min(result[result.length - 1], result[result.length - 2]);
    }
}