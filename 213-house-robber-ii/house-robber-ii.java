class Solution {
    private int[] dp;
    private int maxLoot(int[] nums, int start, int end, int idx) {
        if (idx > end) return 0;
        if (dp[idx] != -1) return dp[idx];
        int steal = nums[idx] + maxLoot(nums, start, end, idx + 2);
        int skip = maxLoot(nums, start, end, idx + 1);
        return dp[idx] = Math.max(steal, skip);
    }
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int case1 = maxLoot(nums, 0, nums.length - 2, 0);
        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int case2 = maxLoot(nums, 1, nums.length - 1, 1);
        return Math.max(case1, case2);
    }
}
