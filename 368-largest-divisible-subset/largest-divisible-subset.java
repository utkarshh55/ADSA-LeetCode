class Solution {
    List<Integer>[][] dp;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        dp = new ArrayList[n + 1][n + 1];
        return helper(0, -1, nums);
    }
    public List<Integer> helper(int i, int prev, int[] nums) {
        if (i == nums.length) {
            return new ArrayList<>();
        }
        if (dp[i][prev + 1] != null) {
            return dp[i][prev + 1];
        }
        List<Integer> take = new ArrayList<>();
        if (prev == -1 || nums[i] % nums[prev] == 0) {
            take.add(nums[i]);
            take.addAll(helper(i + 1, i, nums));
        }
        List<Integer> skip = helper(i + 1, prev, nums);
        if (take.size() > skip.size()) {
            dp[i][prev + 1] = take;
        } else {
            dp[i][prev + 1] = skip;
        }
        return dp[i][prev + 1];
    }
}