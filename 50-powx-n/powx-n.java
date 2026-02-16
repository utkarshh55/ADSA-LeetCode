class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return power(x, N);
    }
    public double power(double x, long n) {
        if (n == 0) return 1;
        double smallPow = power(x, n / 2);
        if (n % 2 == 0) {
            return smallPow * smallPow;
        } else {
            return x * smallPow * smallPow;
        }
    }
}
