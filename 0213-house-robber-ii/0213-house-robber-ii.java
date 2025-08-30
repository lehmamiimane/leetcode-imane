class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        return Math.max(
            robLinear(nums, 0, n - 2),
            robLinear(nums, 1, n - 1)
        );
    }

    private int robLinear(int[] nums, int l, int r) {
        int prev2 = 0;
        int prev1 = 0; 
        for (int i = l; i <= r; i++) {
            int take = prev2 + nums[i];
            int skip = prev1;
            int curr = Math.max(take, skip);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}