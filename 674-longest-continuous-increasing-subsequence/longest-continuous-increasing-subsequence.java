class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int left = 0;
        int maxLen = 1;
        for (int right = 1; right < n; right++) {
            if (nums[right] <= nums[right - 1]) {
                left = right;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}