// Copy Paste
class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        Integer[][] dp = new Integer[n][27]; // 26 = no finger placed
        return solve(word, 0, 26, dp);
    }

    private int solve(String word, int i, int other, Integer[][] dp) {
        if (i == word.length()) return 0;

        if (dp[i][other] != null) return dp[i][other];

        int curr = word.charAt(i) - 'A';
        int prev = (i == 0) ? 26 : word.charAt(i - 1) - 'A';

        // Option 1: use same finger (the one that typed previous char)
        int useSame = solve(word, i + 1, other, dp) + dist(prev, curr);

        // Option 2: use other finger
        int useOther = solve(word, i + 1, prev, dp) + dist(other, curr);

        return dp[i][other] = Math.min(useSame, useOther);
    }

    private int dist(int a, int b) {
        if (a == 26 || b == 26) return 0; // finger not placed yet

        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;

        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}