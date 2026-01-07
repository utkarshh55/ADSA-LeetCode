class Solution {
  public int findClosest(int x, int y, int z) {
    int d1 = Math.abs(z-x);
    int d2 = Math.abs(y - z);
    if (d1 == d2) return 0;
    return d1 < d2 ? 1 : 2;
  }
}