class Solution {
    public int minimumOneBitOperations(int n) {
        if (n == 0) return 0;
        int x = 1;
        // find largest power of two <= n
        while ((x << 1) <= n) x <<= 1;
        // recurse on transformed n, add cost x
        return minimumOneBitOperations(n ^ (x | (x >> 1))) + x;
    }
}
