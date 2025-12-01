class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;
        
        long lo = 0;
        long hi = sum / n; // max possible time per computer
        while (lo < hi) {
            long mid = lo + (hi - lo + 1) / 2; // upper-mid to avoid infinite loop
            long total = 0;
            for (int b : batteries) {
                total += Math.min((long) b, mid);
                // small micro-optimization: we could break if total >= mid * n,
                // but keep simple and safe.
            }
            if (total >= mid * n) {
                lo = mid; // feasible, try larger
            } else {
                hi = mid - 1; // not feasible
            }
        }
        return lo;
    }
}