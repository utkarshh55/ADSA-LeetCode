//Copy PASTE
class Solution {
    public List<Integer> findCoins(int[] numWays) {
        int n = numWays.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (dp[i] != numWays[i - 1]) {
                // i is a denomination
                ans.add(i);

                for (int j = i; j <= n; j++) {
                    dp[j] = dp[j] + dp[j - i];
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dp[i] != numWays[i - 1]) {
                return new ArrayList<>();
            }
        }

        return ans;
    }
}
