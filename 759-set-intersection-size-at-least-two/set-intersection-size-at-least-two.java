//Copy Paste
class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        // Sort by end ascending; if same end, start descending
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(b[0], a[0]); // larger start first
            }
        });

        // a and b are the two largest chosen points (a < b)
        int a = -1, b = -1;
        int ans = 0;

        for (int[] iv : intervals) {
            int start = iv[0], end = iv[1];

            if (start > b) {
                // no overlap with current chosen points -> add two points: end-1, end
                a = end - 1;
                b = end;
                ans += 2;
            } else if (start > a) {
                // only b is in interval -> add one point: end
                a = b;
                b = end;
                ans += 1;
            } else {
                // both a and b are in the interval -> nothing to add
            }
        }

        return ans;
    }
}
