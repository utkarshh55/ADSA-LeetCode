class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;

        int[] points = new int[10001];
        for (int num : nums) {
            points[num] += num;
        }

        int[] dp = new int[10001];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);

        for (int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(points[i] + dp[i-2], dp[i-1]);
        }

        return dp[10000];
    }
}
