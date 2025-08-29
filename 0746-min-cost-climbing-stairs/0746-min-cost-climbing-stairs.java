    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int prev2 = 0, prev1 = 0, curr = 0;

        for (int i = 2; i <= cost.length; i++) {
            curr = Math.min(prev1 + cost[i - 1],
                            prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
        }
    }