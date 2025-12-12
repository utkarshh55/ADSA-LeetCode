class Solution {
    private int[] dp;
    private int maxLoot(int[] nums, int idx) {
        if (idx >= nums.length) return 0;
        if (dp[idx] != -1) return dp[idx];
        int steal = nums[idx] + maxLoot(nums, idx + 2);
        int skip = maxLoot(nums, idx + 1);
        return dp[idx] = Math.max(steal, skip);
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return maxLoot(nums, 0);
    }
}
