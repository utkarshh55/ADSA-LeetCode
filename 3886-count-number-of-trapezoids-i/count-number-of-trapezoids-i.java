import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int countTrapezoids(int[][] points) {
        // frequency of points per y
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            int y = p[1];
            freq.put(y, freq.getOrDefault(y, 0) + 1);
        }

        // compute number of horizontal segments per y: C(m,2)
        List<Long> cnt = new ArrayList<>();
        for (int y : freq.keySet()) {
            long m = freq.get(y);
            if (m >= 2) {
                long segments = (m * (m - 1) / 2) % MOD;
                cnt.add(segments);
            }
        }

        // if < 2 y-levels with segments -> no trapezoid
        if (cnt.size() < 2) return 0;

        // accumulate answer using prefix sum to count pairs
        long ans = 0;
        long pref = 0;
        // order doesn't matter; iterate in any order
        for (long segs : cnt) {
            ans = (ans + segs * pref) % MOD;
            pref = (pref + segs) % MOD;
        }

        return (int) ans;
    }
}
