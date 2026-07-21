class Solution {
    int[] dp;
    Boolean[][] isPal;
    public int minCut(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp, -1);
        isPal = new Boolean[n][n];
        return solve(0, s) - 1;
    }
    public int solve(int i, String s) {
        if (i == s.length())
          return 0;
        if (dp[i] != -1)
            return dp[i];
        int ans = Integer.MAX_VALUE;
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                ans = Math.min(ans, 1 + solve(j + 1, s));
            }
        }
        return dp[i] = ans;
    }
    public boolean isPalindrome(String s, int i, int j) {
        if (isPal[i][j] != null)
            return isPal[i][j];
        int l = i, r = j;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return isPal[i][j] = false;
            l++;
            r--;
        }
        return isPal[i][j] = true;
    }
}