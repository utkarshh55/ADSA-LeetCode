class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, helper(i, nums, dp));
        }
        return ans;
    }
    public int helper(int i, int[] nums, int[] dp) {
        if (i == nums.length - 1) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int take = 1;
        if (nums[i + 1] > nums[i]) {
            take = 1 + helper(i + 1, nums, dp);
        }
        return dp[i] = take;
    }
}